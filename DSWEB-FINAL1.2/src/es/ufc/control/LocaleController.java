package es.ufc.control;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
@ManagedBean

public class LocaleController {
	private Locale currentLocale = new Locale("en", "US");
	
	public void englishLocale(){
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		currentLocale =  Locale.US;
		viewRoot.setLocale(currentLocale);
	}

	public void portugueseLocale(){
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		currentLocale = new Locale("pt", "BR");
		viewRoot.setLocale(currentLocale);
	}
	public Locale getCurrentLocale(){
		return currentLocale;
	}
	
}
