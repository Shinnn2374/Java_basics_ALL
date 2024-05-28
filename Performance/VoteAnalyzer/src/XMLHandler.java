import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XMLHandler extends DefaultHandler
{

    private Voter voter;
    private static final SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("voter") && voter == null){
            Date birthDay;
         try{
             birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
         }catch (ParseException e){
             throw new RuntimeException();
         }
         voter = new Voter(attributes.getValue("name"), birthDay);
        } else if (qName.equals("visit") && voter != null) {
            try {
                DBConnection.countVoter(voter.getName(), birthDayFormat.format(voter.getBirthDay()));
            }catch (SQLException e){
                throw new RuntimeException();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("voter")){
            voter = null;
        }
    }

    public static  void executeParser(String fileName){
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(new File(fileName), handler);
            DBConnection.executeMultiInsert();
        }catch (ParserConfigurationException | SAXException | IOException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
