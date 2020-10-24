package br.com.clinicumlab.controladores;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.enterprise.inject.Model;

/**
 * Classe utilitária que provê métodos relacionados a datas. Anotada com um bean
 * CDI, pode ser usada diretamente nas páginas.
 *
 * @author elisangela <elisangeladesouza@gmail.com>
 */
@Model
public class DateTimeUtilBean implements Serializable {

    private Date date = new Date();
    Calendar calendar = new GregorianCalendar();

    public Date getDateToday() {
        return new Date();
    }

    public Date dateHour() {
        this.date = new Timestamp(date.getTime());
        return date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
