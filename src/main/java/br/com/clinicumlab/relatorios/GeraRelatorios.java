package br.com.clinicumlab.relatorios;

import br.com.clinicumlab.modelo.Paciente;
import br.com.clinicumlab.util.jsf.FacesUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class GeraRelatorios {

    /**
     * Captura o caminho completo onde os arquivos de template compilados
     * (.jasper) do relatório se encontram, contanto que este arquivo esteja na
     * pasta resources.
     *
     * @return
     */
    public String caminhoRelatorio() {
        return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/clinicumlab/relatorios/");
    }

    /**
     * Responsável por receber os parâmetros vindos do arquivo jasper, gerar o
     * relatório e procesar o retorno do mesmo de acordo com as requisições HTTP
     * vindas da camada de apresentação. Depois exporta o relatório para o
     * formato PDF antes de apresentar o mesmo no browser.
     *
     * @param jasperFileName
     * @param pdfFileName
     * @param paciente
     * @throws JRException
     * @throws IOException
     */
    public void gerarPdf(String jasperFileName, String pdfFileName, Paciente paciente) throws JRException, IOException {

        List<Paciente> listaPaciente = new ArrayList<>();
        listaPaciente.add(paciente);
        List<Paciente> atributos = new ArrayList<>();
        listaPaciente.forEach((clieteSelecionado) -> {
            atributos.add(clieteSelecionado);
        });

        Map<String, Object> parametros = new HashMap<>();
        String logo = FacesUtil.caminhoContexto("/resources/clinicumlab/imagens/microscopio.png");
        String assinatura = FacesUtil.caminhoContexto("/resources/clinicumlab/imagens/assinatura.png");
        parametros.put("microscopio", logo);
        parametros.put("assinatura", assinatura);
        parametros.put("nome", paciente.getNome());
        parametros.put("rua", paciente.getRua());
        parametros.put("bairro", paciente.getBairro());
        parametros.put("cidade", paciente.getCidade());
        parametros.put("estado", paciente.getEstado());
        parametros.put("fatorRH", paciente.getFatorRH());
        parametros.put("dataNascimento", paciente.getDataNascimento());
        parametros.put("tipoSanguineo", paciente.getTipoSanguineo());
        String caminhoArquivoJasper = caminhoRelatorio() + jasperFileName;

        JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoArquivoJasper, parametros, new JRBeanCollectionDataSource(atributos));
        HttpServletResponse response = (HttpServletResponse) FacesUtil.responseHTTP();
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=".concat(pdfFileName));

        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }
}
