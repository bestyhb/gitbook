# Abstact
![](../images/2023-06-15-14-14-52.png)

# POM
```XML
<!--iText-->
<dependency>
    <groupId>com.lowagie</groupId>
    <artifactId>itext</artifactId>
    <version>2.1.7</version>
</dependency>
```

# TestDEMO
```JAVA
public void testApp()
{
    String pdfPath="/Users/spring/Documents/iTextDemo-1.pdf";
    Document d=null;
    try
    {
        d=new Document();
        Path p=Paths.get(pdfPath);
        PdfWriter.getInstance(d, Files.newOutputStream(p));
        d.open();
        d.add(new Paragraph("Hello iText"));
    }
    catch (IOException | DocumentException e){
        e.printStackTrace();
    }
    finally {
        assert d!=null;
        d.close();
    }
}
```
