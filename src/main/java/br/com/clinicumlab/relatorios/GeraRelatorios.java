package br.com.clinicumlab.relatorios;

import br.com.clinicumlab.modelo.Atendimento;
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

    private static final String LOGO = FacesUtil.caminhoContexto("/resources/clinicumlab/imagens/microscopio.png");
    private static final String ASSINATURA = FacesUtil.caminhoContexto("/resources/clinicumlab/imagens/assinatura.png");

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
    public void carteirinhaPaciente(String jasperFileName, String pdfFileName, Paciente paciente) throws JRException, IOException {

        List<Paciente> listaPaciente = new ArrayList<>();
        listaPaciente.add(paciente);
        List<Paciente> atributos = new ArrayList<>();
        listaPaciente.forEach((clieteSelecionado) -> {
            atributos.add(clieteSelecionado);
        });

        Map<String, Object> parametros = new HashMap<>();

        parametros.put("microscopio", LOGO);
        parametros.put("assinatura", ASSINATURA);
        parametros.put("nome", paciente.getNome());
        parametros.put("rua", paciente.getRua());
        parametros.put("bairro", paciente.getBairro());
        parametros.put("cidade", paciente.getCidade());
        parametros.put("estado", paciente.getEstado());
        parametros.put("fatorRH", paciente.getFatorRH());
        parametros.put("dataNascimento", paciente.getDataNascimento());
        parametros.put("tipoSanguineo", paciente.getTipoSanguineo());
        String caminhoArquivoJasper = caminhoRelatorio() + jasperFileName;

        geraPDF(caminhoArquivoJasper, pdfFileName, parametros, atributos);
    }
    
    public void resultadoExame(String jasperFileName, String pdfFileName, Atendimento atendimento) throws JRException, IOException {

        List<Atendimento> listaAtendimento = new ArrayList<>();
        listaAtendimento.add(atendimento);
        List<Atendimento> atributos = new ArrayList<>();
        listaAtendimento.forEach((atendimentoSelecionado) -> {
            atributos.add(atendimentoSelecionado);
        });

        Map<String, Object> parametros = new HashMap<>();

        String caminhoArquivoJasper = caminhoRelatorio() + jasperFileName;

        geraPDF(caminhoArquivoJasper, pdfFileName, parametros, atributos);
    }

    private void geraPDF(String caminhoArquivoJasper, String pdfFileName, Map<String, Object> parametros, List<?> atributos) throws JRException, IOException {
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
