package file.reader;

import com.opencsv.bean.CsvBindByName;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Table {

    static public List<Table> list;
    static Pattern pattern_def_name = Pattern.compile("##__");
    static Pattern pattern_cena = Pattern.compile("cena");
    static Pattern pattern_null = Pattern.compile("null");

    @Override
    public String toString() {
        return "{" +
                Material + '\'' +
                Definition_Name + '\'' +
                LenY + ' ' +
                LenX + ' ' +
                LenZ + ' ' +
                Quantity + ' ' +
                Kant_duzina + ' ' +
                Kant_sirina + ' ' +
                Traka_materijal + '\'' +
                Traka_debljina + ' ' +
                Naziv + '\'' +
                Cena_dinari +
                '}';
    }


    @CsvBindByName(column = "Material")
    String Material;

    @CsvBindByName(column = "Definition_Name")
    String Definition_Name;

    Tip tip;

    public Tip getTip() {
        return tip;
    }

    public void setDefinition_Name(String definition_Name) {
        Definition_Name = definition_Name;

        Matcher matcher;
        boolean matchFound;

        matcher = pattern_cena.matcher(definition_Name);
        matchFound = matcher.find();
        if (matchFound)
            tip = Tip.Proizvod;
        tip = Tip.Element;
    }

    public String materijal_unique(){
        String tektura = "-";
        return Material + LenZ + tektura;
    }

    public String traka_unique(){
        return Traka_materijal + Traka_debljina;
    }

    @CsvBindByName(column = "LenY")
    String stringLenY;
    int LenY;

    @CsvBindByName(column = "LenX")
    String stringLenX;
    int LenX;

    @CsvBindByName(column = "LenZ")
    String stringLenZ;
    int LenZ;

    @CsvBindByName(column = "Quantity")
    int Quantity;

    @CsvBindByName(column = "Kant_duzina")
    int Kant_duzina;

    @CsvBindByName(column = "Kant_sirina")
    int Kant_sirina;

    @CsvBindByName(column = "Traka_materijal")
    String Traka_materijal;

    @CsvBindByName(column = "Traka_debljina")
    String stringTraka_debljina;
    int Traka_debljina;

    @CsvBindByName(column = "Naziv")
    String Naziv;

    @CsvBindByName(column = "Cena_dinari")
    int Cena_dinari;

    //    @CsvBindByName(column = "Napomena")
//    String Napomena;


    public String getNaziv() {
        return Naziv;
    }

    public String getMaterial() {
        return Material;
    }

    public int getLenY() {
        return LenY;
    }

    public int getLenX() {
        return LenX;
    }

    public int getLenZ() {
        return LenZ;
    }

    public int getQuantity() {
        return Quantity;
    }

    public int getCena_dinari() {
        return Cena_dinari;
    }

    public void setStringLenY(String stringLenY) {
        this.stringLenY = stringLenY;
        this.LenY = Integer.parseInt(stringLenY.substring(0, stringLenY.length() - 3));
    }

    public void setStringLenX(String stringLenX) {
        this.stringLenX = stringLenX;
        this.LenX = Integer.parseInt(stringLenX.substring(0, stringLenX.length() - 3));

    }

    public void setStringLenZ(String stringLenZ) {
        this.stringLenZ = stringLenZ;
        this.LenZ = Integer.parseInt(stringLenZ.substring(0, stringLenZ.length() - 3));
    }

    public void setStringTraka_debljina(String stringTraka_debljina) {
        this.stringTraka_debljina = stringTraka_debljina;
        if (stringTraka_debljina != "")
            this.Traka_debljina = Integer.parseInt(stringTraka_debljina.substring(0, stringTraka_debljina.length() - 3));

    }
}
