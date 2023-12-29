package elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements {
   public By konumIzniErisimiVerButonu = By.id("com.inomera.sm:id/buttonAllowLocationPermission");

   public By konumUygulamayiKullairkenIzinVer = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");

   public By menuTanitim =By.id("com.inomera.sm:id/textViewToolTip");
   public By yardimTanitim =By.id("com.inomera.sm:id/textViewSupportToolTip");
   public By bildirimTercihleriniBelirle =By.id("com.inomera.sm:id/permissionButton");
   public By bildirimlereIzinVer =By.id("android:id/button1");
   public By teslimatYontemiSec =By.id("com.inomera.sm:id/regionInfoCard");
   public By uyeOlmadanDevamEt =By.id("com.inomera.sm:id/logoutContinueButton");
   public By magazadanAlacagim =By.id("com.inomera.sm:id/storePickCardView");

   public By sehirler = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.inomera.sm:id/addressesRecyclerView\"]/android.view.ViewGroup");
   public By ilceler = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.inomera.sm:id/addressesRecyclerView\"]/android.view.ViewGroup");
   public By magazalar = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.inomera.sm:id/addressesRecyclerView\"]/android.view.ViewGroup/..//android.widget.TextView");
   public By secilenMagaza = By.id("com.inomera.sm:id/townTextView");
   public By adresimeGelsin = By.id("com.inomera.sm:id/lastMileImageView");
   public By isaretledigimKonumuEkle = By.id("com.inomera.sm:id/btnSave");
   public By caddeSokak = By.id("com.inomera.sm:id/editTextStreet");
   public By binaNo = By.id("com.inomera.sm:id/buildingNoEditText");
   public By katNo = By.id("com.inomera.sm:id/floorEditText");
   public By daireNo = By.id("com.inomera.sm:id/doorNumberEditText");
   public By adresTarifi = By.id("com.inomera.sm:id/addressDirectionEditText");
   public By adresBasligi = By.id("com.inomera.sm:id/addressNameEditText");
   public By ad = By.id("com.inomera.sm:id/firstNameEditText");
   public By soyAd = By.id("com.inomera.sm:id/lastNameEditText");
   public By adresKaydetButonu = By.id("com.inomera.sm:id/saveButton");
   public By adresimDogru = By.id("com.inomera.sm:id/buttonConfirm");
   public By secilenAdresBasligi = By.id("com.inomera.sm:id/regionTextView");
   public By formuEksiksizDoldurunPopUp = By.id("com.inomera.sm:id/tvText");

   public By neyeIhtiyacinVar = By.id("com.inomera.sm:id/textInputEditText");

   public By searchBox = By.id("com.inomera.sm:id/searchTextInputEditText");

   public By urunler = By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.inomera.sm:id/main_layout\"])");
   public By urunFiyat = By.id("com.inomera.sm:id/priceTextView");

   public By sepeteEkleButonu = By.id("com.inomera.sm:id/addToCartButton");
   public By sepetim = By.id("com.inomera.sm:id/cartAction");
   public By sepetimeDevamEtButonu = By.id("com.inomera.sm:id/cartAction");
   public By sepettekiUrunFiyati = By.id("com.inomera.sm:id/price_text_view");
   public By sepettekiIndirimliUrunFiyati = By.id("com.inomera.sm:id/txt_badge_right");

   public By ilgiliSonuclar = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.inomera.sm:id/rvAutoComplete\"]/android.view.ViewGroup");

   public By urunuArttir = By.xpath("(//android.widget.LinearLayout[@content-desc=\"Ürünü 1 arttır\"])[1]");
   public By urunuAzalt = By.xpath("(//android.widget.LinearLayout[@content-desc=\"Ürünü 1 azalt\"])[1]");
   public By urunuSil = By.id("com.inomera.sm:id/btn_delete");
   public By urunuAdeti = By.xpath("(//android.widget.TextView[@resource-id=\"com.inomera.sm:id/number_counter_text_view\"])[1]");
   public By sepetindeUrunBulunmuyor = By.id("com.inomera.sm:id/tv_first_message");
   public By geriButonu = By.className("android.widget.ImageButton");
   public By sepeteEklemeArtiButonu = By.xpath("//androidx.cardview.widget.CardView[@resource-id=\"com.inomera.sm:id/add_to_cart_button\"]/android.view.ViewGroup/android.widget.ImageView");
   public By altMenuSepetim = By.id("com.inomera.sm:id/action_cart");
   public By sepettekiUrunler = By.xpath("//android.view.ViewGroup[@resource-id=\"com.inomera.sm:id/cartItemRootLayout\"]");
   public By altMenuSepeteDevamEt = By.id("com.inomera.sm:id/continue_cart_button");
   public By arananUrunSayisi = By.xpath("(//android.widget.TextView[@text])[2]");
   public By toplamSepetTutari = By.id("com.inomera.sm:id/cart_total_text_view");























}
