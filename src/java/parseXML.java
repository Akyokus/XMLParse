
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

@ManagedBean
@SessionScoped
public class parseXML {

    private List<supClass> liste;
    
    public static void main(String[] args) {
        
    }

    public List<supClass> getListe() {
        try {
            liste = new ArrayList<>();
           File inputFile = new File("C:/Users/mehme/OneDrive/Belgeler/NetBeansProjects/XMLParse/web/WEB-INF/ogrenci.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
           NodeList nodelist = doc.getElementsByTagName("student");

            for (int i = 0; i < nodelist.getLength(); i++) {
                
                supClass sc = new supClass();
                Element element = (Element) nodelist.item(i);
                sc.setKayitNo(Integer.parseInt(element.getElementsByTagName("kayitNo").item(0).getTextContent())); //aynı isimde 1den fazla tanımlamada item indexi değişir
                sc.setOgrNo(Integer.parseInt(element.getElementsByTagName("ogrNo").item(0).getTextContent()));
                sc.setIsim(element.getElementsByTagName("isim").item(0).getTextContent());
                sc.setbIsim(element.getElementsByTagName("bIsim").item(0).getTextContent());
                sc.setNotOrt(Integer.parseInt(element.getElementsByTagName("notOrt").item(0).getTextContent()));
                sc.setUrl(element.getElementsByTagName("url").item(0).getTextContent());

                liste.add(sc);
            }
        } catch (Exception e) {

            System.err.println("Hata oluştu " + e);

        }
        return liste;
    }

    public void setListe(List<supClass> liste) {
        this.liste = liste;
    }
    
   
}
