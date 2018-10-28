package herramientas;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class HighlightEvaluator implements IDateEvaluator{
	
	private Color color;
	private List<Date> dates = new ArrayList<>();
	
	public HighlightEvaluator () {
		this.color = null;
		this.setDates(new ArrayList<>());
	}
	
	public HighlightEvaluator (Color color) {
		this.color = color;
		this.dates = new ArrayList<>();
	}
	
	public void add(Date date){
		getDates().add(date);
	}
	
	public Date createDate(int d,int m) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, d);
        calendar.set(Calendar.MONTH,m);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return (calendar.getTime());
    }
	
	public Date createDate(int d) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, d);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return (calendar.getTime());
    }
	
	private Color getColor() { 
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public List<Date> getDates() {
		return dates;
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

    @Override
    public boolean isSpecial(Date date) {
        return dates.contains(date);
    }

    @Override
    public Color getSpecialForegroundColor() {
        return Color.red.darker();
    }

    @Override
    public Color getSpecialBackroundColor() {
        return getColor();
    }

	@Override
	public String getSpecialTooltip() {
		return "Highlighted event.";
	}

	@Override
	public boolean isInvalid(Date date) {
		return false;
	}

	@Override
	public Color getInvalidForegroundColor() {
		return null;
	}

	@Override
	public Color getInvalidBackroundColor() {
		return null;
	}

	@Override
	public String getInvalidTooltip() {
		return null;
	}	

}
