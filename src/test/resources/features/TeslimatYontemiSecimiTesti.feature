Feature: Migros Teslimat Yöntemi Seçimi
  Scenario: Magazadan Alacağım Seçeneğinde Rastgele Teslimat Bölgesi Seçilir
    When Konum izni erişimi ver butonuna tıklanır
    And Uygulamayı kullanırken izin ver seçilir
    Then Menü ve Yardım Butonlarının tanıtımları geçilir
    Then Bildirim Tercihleri Belirlenir
    Then Teslimat Yöntemi Mağazadan Alacağım Seçilir
    Then Rastgele Teslimat Şehri Seçilir
    Then Rastgele Teslimat İlçesi Seçilir
    And  Rastgele Teslimat Magazasi Seçilir ve seçilmiş olarak görünen magaza ile aynı olduğu doğrulanır


  Scenario: Adresime Gelsin Seçilir
    When Konum izni erişimi ver butonuna tıklanır
    And Uygulamayı kullanırken izin ver seçilir
    Then Menü ve Yardım Butonlarının tanıtımları geçilir
    Then Bildirim Tercihleri Belirlenir
    Then Teslimat Yöntemi Adresime Gelsin Seçilir
    Then İşaretlediğim Konumu Ekle Butonuna Tıklanır
    Then Adres Bilgileri Eklenir
    Then Kişisel Bilgiler Eklenir
    And  Kaydet Butonuna Tıklanır
    And  Adresim Doğru Seçilir
    And  Adres Başlığının, Yazılan Adres Başlığı İle Aynı olduğu Doğrulanır


  Scenario: Adres Bilgilerinin Eksik Olması Durumunda 'Lütfen formu eksiksiz doldurunuz.' Mesajı Görüntülenir
    When Konum izni erişimi ver butonuna tıklanır
    And Uygulamayı kullanırken izin ver seçilir
    Then Menü ve Yardım Butonlarının tanıtımları geçilir
    Then Bildirim Tercihleri Belirlenir
    Then Teslimat Yöntemi Adresime Gelsin Seçilir
    Then İşaretlediğim Konumu Ekle Butonuna Tıklanır
    Then Cadde, Sokak Alanı boş bırakılır
    Then Diğer Adres Bilgileri Eklenir
    Then Kişisel Bilgiler Eklenir
    And  Kaydet Butonuna Tıklanır
    And  Lütfen formu eksiksiz doldurunuz. mesajının görüntülendiği doğrulanır










