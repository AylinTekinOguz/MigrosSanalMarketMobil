package utilities;

import com.github.javafaker.Faker;
import elements.Elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.time.Duration.ofMillis;
import static utilities.Driver.appiumDriver;


public class ReusableMethods {

    Elements elements = new Elements();
    Faker faker = new Faker(Locale.forLanguageTag("TR"));
    public  void visibleElement(By locator) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public  WebElement find(By locator) {
        visibleElement(locator);
        return appiumDriver.findElement(locator);
    }

    public  void textYaz(By element, String text){
        appiumDriver.findElement(element).sendKeys(text);
    }



    public  void swipeUpAccordingToPhoneSize() {
        if (appiumDriver instanceof AndroidDriver) {
            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;
            System.out.println("Android1 : " + width + " - " + height);
            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 60) / 100;
            int swipeEndHeight = (height * 20) / 100;
            System.out.println("Start width: " + swipeStartWidth + " - Start height: " + swipeStartHeight + " - End height: " + swipeEndHeight);
            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeEndHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeStartHeight))
                    .release()
                    .perform();
        } else {
            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 40) / 100;
            int swipeEndHeight = (height * 20) / 100;
            // appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeStartHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeEndHeight))
                    .release()
                    .perform();
        }
    }

    public  void randomKaydir(){
        int randomSayi = ThreadLocalRandom.current().nextInt(0,20);
        for (int i = 0; i < randomSayi; i++) {
            swipeUpAccordingToPhoneSize();
        }
    }

    public List<WebElement> findAll(By locator) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }


    public void listtenRandomSec(By element) throws InterruptedException {
        List<WebElement> list = findAll(element);
        int elementCount = list.size();
        Random random = new Random();
        int randomValueOfElements = random.nextInt(elementCount);
        list.get(randomValueOfElements).click();
        bekle(2);
    }
    public  String sepettekiUrunFiyatiBul(By urun1, By urun2){
        String sepettekiUrunFiyati = "";
        if (find(urun1).isDisplayed()){
            sepettekiUrunFiyati=find(urun1).getText();
        } else if (find(urun2).isDisplayed()) {
            sepettekiUrunFiyati= find(urun2).getText();
        }
        return sepettekiUrunFiyati;
    }


    //HARD WAIT METHOD
    @Given("{int} saniye beklenir")
    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }





    public void tikla(By element){

        appiumDriver.findElement(element).click();


    }

    @When("Konum izni erişimi ver butonuna tıklanır")
    public void konumIzniErişimiVerButonunaTıklanır() {
        bekle(2);
        tikla(elements.konumIzniErisimiVerButonu);
        bekle(2);
    }
    @When("Uygulamayı kullanırken izin ver seçilir")
    public void uygulamayıKullanırkenIzinVerSeçilir() {
        tikla(elements.konumUygulamayiKullairkenIzinVer);
    }

    @When("Menü ve Yardım Butonlarının tanıtımları geçilir")
    public void menüVeYardımButonlarınınTanıtımlarıGeçilir() {
        bekle(3);
        tikla(elements.menuTanitim);
        bekle(3);
        tikla(elements.yardimTanitim);

    }

    @When("Bildirim Tercihleri Belirlenir")
    public void bildirimTercihleriBelirlenir() {
        bekle(5);
        tikla(elements.bildirimTercihleriniBelirle);
        bekle(1);
        tikla(elements.bildirimlereIzinVer);
    }


    @Then("Teslimat Yöntemi Mağazadan Alacağım Seçilir")
    public void teslimatYöntemiMağazadanAlacağımSeçilir() {

       bekle(1);
       tikla(elements.teslimatYontemiSec);
       bekle(1);
       tikla(elements.uyeOlmadanDevamEt);
       bekle(1);
       tikla(elements.magazadanAlacagim);
    }

    @Then("Rastgele Teslimat Şehri Seçilir")
    public void rastgeleTeslimatŞehriSeçilir() throws InterruptedException {
        bekle(3);
        randomKaydir();
        listtenRandomSec(elements.sehirler);
    }

    @Then("Rastgele Teslimat İlçesi Seçilir")
    public void rastgeleTeslimatİlçesiSeçilir() throws InterruptedException {
        listtenRandomSec(elements.ilceler);
        bekle(5);
    }

    @And("Rastgele Teslimat Magazasi Seçilir ve seçilmiş olarak görünen magaza ile aynı olduğu doğrulanır")
    public void rastgeleTeslimatMagazasiSeçilirVeSeçilmişOlarakGörünenMagazaIleAynıOlduğuDoğrulanır() {
        List<WebElement> list =findAll(elements.magazalar);
        int elementCount = list.size();
        Random random = new Random();
        int randomValueOfElements = random.nextInt(elementCount);
        String secilenElementText = list.get(randomValueOfElements).getText();
        list.get(randomValueOfElements).click();
        bekle(2);
        Assertions.assertEquals(secilenElementText, find(elements.secilenMagaza).getText());
    }

    @Then("Teslimat Yöntemi Adresime Gelsin Seçilir")
    public void teslimatYöntemiAdresimeGelsinSeçilir() {
        bekle(1);
        tikla(elements.teslimatYontemiSec);
        bekle(1);
        tikla(elements.uyeOlmadanDevamEt);
        bekle(1);
        tikla(elements.adresimeGelsin);
        bekle(1);

    }

    @Then("İşaretlediğim Konumu Ekle Butonuna Tıklanır")
    public void işaretlediğimKonumuEkleButonunaTıklanır() {
       tikla(elements.isaretledigimKonumuEkle);
       bekle(1);
    }

    @Then("Adres Bilgileri Eklenir")
    public void adresBilgileriEklenir() {
        textYaz(elements.caddeSokak, faker.address().streetName());
        textYaz(elements.binaNo, faker.address().buildingNumber());
        textYaz(elements.katNo, (""+(faker.number().numberBetween(0,10))));
        textYaz(elements.daireNo, (""+(faker.number().numberBetween(1,40))));
        textYaz(elements.adresTarifi, faker.lorem().paragraph(1));
        textYaz(elements.adresBasligi, "Ev Adresi");
        bekle(2);

    }

    @Then("Kişisel Bilgiler Eklenir")
    public void kişiselBilgilerEklenir() {
        swipeUpAccordingToPhoneSize();
        textYaz(elements.ad, faker.name().firstName());
        textYaz(elements.soyAd, faker.name().lastName());
    }

    @And("Kaydet Butonuna Tıklanır")
    public void kaydetButonunaTıklanır() {
        tikla(elements.adresKaydetButonu);
        bekle(2);
    }

    @And("Adresim Doğru Seçilir")
    public void adresimDoğruSeçilir() {
        tikla(elements.adresimDogru);
        bekle(2);
    }

    @And("Adres Başlığının, Yazılan Adres Başlığı İle Aynı olduğu Doğrulanır")
    public void adresBaşlığınınYazılanAdresBaşlığıİleAynıOlduğuDoğrulanır() {
        Assertions.assertEquals("Ev Adresi", appiumDriver.findElement(elements.secilenAdresBasligi).getText());
        bekle(2);
    }

    @Then("Cadde, Sokak Alanı boş bırakılır")
    public void caddeSokakAlanıBoşBırakılır() {
        appiumDriver.findElement(elements.caddeSokak).clear();
    }

    @Then("Diğer Adres Bilgileri Eklenir")
    public void diğerAdresBilgileriEklenir() {
        textYaz(elements.binaNo, faker.address().buildingNumber());
        textYaz(elements.katNo, (""+(faker.number().numberBetween(0,10))));
        textYaz(elements.daireNo, (""+(faker.number().numberBetween(1,40))));
        textYaz(elements.adresTarifi, faker.lorem().paragraph(1));
        textYaz(elements.adresBasligi, "Ev Adresi");
        bekle(2);

    }

    @And("Lütfen formu eksiksiz doldurunuz. mesajının görüntülendiği doğrulanır")
    public void lütfenFormuEksiksizDoldurunuzMesajınınGörüntülendiğiDoğrulanır() {
        Assertions.assertEquals("Lütfen formu eksiksiz doldurunuz.", appiumDriver.findElement(elements.formuEksiksizDoldurunPopUp).getText());
        bekle(2);
    }
    @Then("Neye ihtiyacin var? alanına tıklanir")
    public void neyeIhtiyacinVarAlanınaTıklanir() {
        bekle(3);
        appiumDriver.findElement(elements.neyeIhtiyacinVar).click();
    }
    @Then("Arama alaninda {string} aratilir")
    public void aramaAlanindaAratilir(String urun) {

        bekle(3);
        appiumDriver.findElement(elements.searchBox).sendKeys(urun);
        bekle(2);
    }


    @Then("İlgili Sonuçlardan rastgele bir seçim yapilir")
    public void ilgiliSonuçlardanRastgeleBirSeçimYapilir() throws InterruptedException {
        listtenRandomSec(elements.ilgiliSonuclar);
        bekle(3);
    }

    @And("Arama sonuçlarından herhangi biri sepete eklenir ve ürün fiyatı ile sepetteki fiyatın aynı olduğu doğrulanır")
    public void aramaSonuçlarındanHerhangiBiriSepeteEklenirVeÜrünFiyatıIleSepettekiFiyatınAynıOlduğuDoğrulanır() throws InterruptedException {
        bekle(3);
        randomKaydir();
        listtenRandomSec(elements.urunler);
        bekle(2);
        String urunFiyati = find(elements.urunFiyat).getText();
        tikla(elements.sepeteEkleButonu);
        bekle(2);
        tikla(elements.sepetim);
        bekle(2);
        tikla(elements.sepetimeDevamEtButonu);
        bekle(3);
        if (appiumDriver.findElement(elements.sepettekiUrunFiyati).isDisplayed()){
            Assertions.assertEquals(urunFiyati, elements.sepettekiUrunFiyati);
        }else {
            Assertions.assertEquals(urunFiyati, elements.sepettekiIndirimliUrunFiyati);
        }


    }

    @Then("Sepetteki ürün sayisi 1 arttirilir")
    public void sepettekiÜrünSayisiArttirilir() {
        tikla(elements.urunuArttir);
        bekle(3);
    }

    @And("Ürün sayisinin {int} adet olduğu doğrulanir")
    public void ürünSayisininOlduğuDoğrulanir(int arg0) {
        Assertions.assertEquals("2 adet", find(elements.urunuAdeti).getText());
    }

    @And("Sepetteki ürün silinir")
    public void sepettekiÜrünSilinir() {
        bekle(2);
        tikla(elements.urunuAzalt);
        bekle(2);
        tikla(elements.urunuSil);
        bekle(2);

    }

    @And("Sepetinde hiç ürün bulunmuyor. yazısının görüntülendiği doğrulanır")
    public void sepetindeHiçÜrünBulunmuyorYazısınınGörüntülendiğiDoğrulanır() {
        Assertions.assertEquals("Sepetinde hiç ürün bulunmuyor.", appiumDriver.findElement(elements.sepetindeUrunBulunmuyor).getText());
    }

    @Then("Geri butonuna tıklanir")
    public void geriButonunaTıklanir() {
        bekle(1);
        tikla(elements.geriButonu);
    }

    @Then("Arama sonuçlarından herhangi biri sepete eklenir")
    public void aramaSonuçlarındanHerhangiBiriSepeteEklenir() throws InterruptedException {
        try {
            bekle(3);
            randomKaydir();
            listtenRandomSec(elements.sepeteEklemeArtiButonu);
            bekle(2);
        }catch (Exception e){
            bekle(3);
            tikla(elements.geriButonu);
            aramaKutusunaTıklanır();
            aramaAlanindaAratilir("sebze");
            ilgiliSonuçlardanRastgeleBirSeçimYapilir();
            aramaSonuçlarındanHerhangiBiriSepeteEklenir();
        }

        
    }

    @Then("Sepetim butonuna tıklanır")
    public void sepetimButonunaTıklanır() {
        tikla(elements.altMenuSepetim);
        bekle(2);
    }

    @And("Sepette {int} farklı ürün olduğu doğrulanır")
    public void sepetteFarklıÜrünOlduğuDoğrulanır(int urunAdeti) {
        bekle(2);
        List<WebElement> list = findAll(elements.sepettekiUrunler);
        Assertions.assertEquals(list.size(),urunAdeti);
    }

    @Then("Arama kutusuna tıklanır")
    public void aramaKutusunaTıklanır() {
        tikla(elements.searchBox);
    }

    @Then("Sepete Devam Et Butonuna Tıklanır")
    public void sepeteDevamEtButonunaTıklanır() {
        bekle(1);
        tikla(elements.altMenuSepeteDevamEt);
    }

    @And("Sepete eklenen ürünlerin toplam fiyatının sepet fiyatıyla aynı olduğu doğrulanır")
    public void sepeteEklenenÜrünlerinToplamFiyatınınSepetFiyatıylaAynıOlduğuDoğrulanır() {
        try {
            List<WebElement> list = findAll(elements.sepettekiUrunFiyati);
            Double ilkUrunFiyat =Double.valueOf(list.get(0).getText().split("T")[0].replace(",", "."));
            Double ikinciUrunFiyati = Double.valueOf(list.get(1).getText().split("T")[0].replace(",", "."));
            Double toplamFiyat = ilkUrunFiyat+ikinciUrunFiyati;

            Double sepetToplamFiyati = Double.valueOf(appiumDriver.findElement(elements.toplamSepetTutari).getText().split(" ")[0].replace(",", "."));
            Assertions.assertEquals(toplamFiyat,sepetToplamFiyati,0.01);
        }catch (Exception e){
            try {
                List<WebElement> list = findAll(elements.sepettekiIndirimliUrunFiyati);
                Double ilkUrunFiyat =Double.valueOf(list.get(0).getText().split(" ")[0].replace(",", "."));
                Double ikinciUrunFiyati = Double.valueOf(list.get(1).getText().split(" ")[0].replace(",", "."));
                Double toplamFiyat = ilkUrunFiyat+ikinciUrunFiyati;

                Double sepetToplamFiyati = Double.valueOf(appiumDriver.findElement(elements.toplamSepetTutari).getText().split(" ")[0].replace(",", "."));
                Assertions.assertEquals(toplamFiyat,sepetToplamFiyati,0.01);
            }catch (Exception exception){
                Double ilkUrunFiyat = Double.valueOf(appiumDriver.findElement(elements.sepettekiIndirimliUrunFiyati).getText().split(" ")[0].replace(",", "."));
                Double ikinciUrunFiyati = Double.valueOf(appiumDriver.findElement(elements.sepettekiUrunFiyati).getText().split(" ")[0].replace(",", "."));
                Double toplamFiyat =ilkUrunFiyat+ikinciUrunFiyati;

                Double sepetToplamFiyati = Double.valueOf(appiumDriver.findElement(elements.toplamSepetTutari).getText().split(" ")[0].replace(",", "."));
                Assertions.assertEquals(toplamFiyat,sepetToplamFiyati, 0.01);
            }


        }


    }

    @Then("Arama sonuçlarından rastgele sayıda seçim sepete eklenir")
    public void aramaSonuçlarındanRastgeleSayıdaSeçimSepeteEklenir() throws InterruptedException {
       String urunSayisiText = appiumDriver.findElement(elements.arananUrunSayisi).getText().split(" ")[0];
        Integer urunSayisi = Integer.valueOf(urunSayisiText);



            if (urunSayisi>1){
                tikla(elements.sepeteEklemeArtiButonu);
                swipeUpAccordingToPhoneSize();
                swipeUpAccordingToPhoneSize();
                listtenRandomSec(elements.sepeteEklemeArtiButonu);
            }else {
                tikla(elements.geriButonu);
                aramaKutusunaTıklanır();
                aramaAlanindaAratilir("deterjan");
                String urunSayisiText2 = appiumDriver.findElement(elements.arananUrunSayisi).getText().split(" ")[0];
                Integer urunSayisi2 = Integer.valueOf(urunSayisiText);
                tikla(elements.sepeteEklemeArtiButonu);
                swipeUpAccordingToPhoneSize();
                swipeUpAccordingToPhoneSize();
                listtenRandomSec(elements.sepeteEklemeArtiButonu);
            }
        }



    }
