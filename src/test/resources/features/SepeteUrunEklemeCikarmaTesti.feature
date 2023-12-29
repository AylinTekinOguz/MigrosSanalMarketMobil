@US02
Feature: Sepete Urun Ekleme Cikarma Testi
  Background:
    When Konum izni erişimi ver butonuna tıklanır
    And Uygulamayı kullanırken izin ver seçilir
    Then Menü ve Yardım Butonlarının tanıtımları geçilir
    Then Bildirim Tercihleri Belirlenir
    Then Teslimat Yöntemi Mağazadan Alacağım Seçilir
    Then Rastgele Teslimat Şehri Seçilir
    Then Rastgele Teslimat İlçesi Seçilir
    And  Rastgele Teslimat Magazasi Seçilir ve seçilmiş olarak görünen magaza ile aynı olduğu doğrulanır
    Then Neye ihtiyacin var? alanına tıklanir
    
  @UrunEkleme
  Scenario: Sepete Urun Eklenebilmeli
    Then Arama alaninda "kahve" aratilir
    Then İlgili Sonuçlardan rastgele bir seçim yapilir
    And Arama sonuçlarından herhangi biri sepete eklenir ve ürün fiyatı ile sepetteki fiyatın aynı olduğu doğrulanır
    
  @UrunArttirma
  Scenario: Sepetteki Urun Sayisi Arttirilabilmeli
    Then Arama alaninda "çay" aratilir
    Then İlgili Sonuçlardan rastgele bir seçim yapilir
    And Arama sonuçlarından herhangi biri sepete eklenir ve ürün fiyatı ile sepetteki fiyatın aynı olduğu doğrulanır
    Then Sepetteki ürün sayisi 1 arttirilir
    And Ürün sayisinin 2 adet olduğu doğrulanir

 @UrunSilme
  Scenario: Sepetteki ürünler silinebilmeli
    Then Arama alaninda "sabun" aratilir
    Then İlgili Sonuçlardan rastgele bir seçim yapilir
    Then Arama sonuçlarından herhangi biri sepete eklenir ve ürün fiyatı ile sepetteki fiyatın aynı olduğu doğrulanır
    Then Sepetteki ürün silinir
    And  Sepetinde hiç ürün bulunmuyor. yazısının görüntülendiği doğrulanır

  @FarkliUrunlerEkleme
   Scenario: Sepete birbirinden farkli ürünler eklenebilmeli
    Then Arama alaninda "sebze" aratilir
    Then İlgili Sonuçlardan rastgele bir seçim yapilir
    Then Arama sonuçlarından herhangi biri sepete eklenir
    Then Geri butonuna tıklanir
    Then Arama kutusuna tıklanır
    Then Arama alaninda "meyve" aratilir
    Then İlgili Sonuçlardan rastgele bir seçim yapilir
    Then Arama sonuçlarından herhangi biri sepete eklenir
    Then Sepetim butonuna tıklanır
    Then Sepete Devam Et Butonuna Tıklanır
    And  Sepette 2 farklı ürün olduğu doğrulanır

  @ToplamFiyat
    Scenario: Sepete eklenen ürünlerin toplam fiyatı sepet fiyatıyla aynı olmalı
    Then Arama alaninda "sebze" aratilir
    Then İlgili Sonuçlardan rastgele bir seçim yapilir
    Then Arama sonuçlarından rastgele sayıda seçim sepete eklenir
    Then Sepetim butonuna tıklanır
    Then Sepete Devam Et Butonuna Tıklanır
    And  Sepete eklenen ürünlerin toplam fiyatının sepet fiyatıyla aynı olduğu doğrulanır






