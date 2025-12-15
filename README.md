# 💣 Bomb Game App

**Bomb Game App**, Kotlin ve modern Android UI aracı **Jetpack Compose** kullanılarak geliştirilmiş, heyecan verici ve basit bir şans oyunudur. Oyuncuların amacı, gizli bombalara basmadan mümkün olduğunca çok kutuyu açarak en yüksek skoru elde etmektir.

## 📱 Ekran Görüntüleri

<p align="center">
  <img src="screenshots/gameplay.png" alt="Oyun Ekranı" width="300" />
</p>

## 🎮 Nasıl Oynanır?

1. **Oyuna Başla:** Ekranda 28 adet (7x4) kapalı kutu bulunur.
2. **Kutuları Seç:** Herhangi bir kutuya tıklayarak şansını dene.
   - 🟢 **Yeşil:** Güvendesin! Puan kazandın.
   - 🔴 **Kırmızı:** BOOM! Bombayı buldun, oyun biter.
3. **Zorluğu Ayarla:** Oyun başlamadan önce `+` ve `-` butonlarını kullanarak sahadaki bomba sayısını **1 ile 5 arasında** değiştirebilirsin.
4. **Skorunu Katla:** Her güvenli kutu skorunu 1 artırır.
5. **Yeniden Başlat:** Yandığında veya istediğin zaman "Restart" butonu ile yeni bir oyuna başla.

## 🛠️ Teknolojiler ve Kütüphaneler

Bu proje, modern Android geliştirme standartlarına uygun olarak tasarlanmıştır:

* **Dil:** [Kotlin](https://kotlinlang.org/)
* **UI Framework:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material3)
* **Minimum SDK:** 26 (Android 8.0 Oreo)
* **Target SDK:** 36
* **Build Sistemi:** Gradle (Kotlin DSL)

## 📂 Proje Yapısı

* `MainActivity.kt`: Uygulamanın giriş noktası ve temel iskeleti.
* `MainMenu.kt`: Oyunun tüm mantığının (State yönetimi, Grid yapısı, Skor hesabı) bulunduğu ana bileşen.
* `ui/theme`: Uygulamanın renk ve tipografi ayarları.

## 🚀 Kurulum

Projeyi yerel makinenizde çalıştırmak için aşağıdaki adımları izleyin:

1.  Bu depoyu klonlayın:
    ```bash
    git clone [https://github.com/kullaniciadi/bomb-game-app.git](https://github.com/kullaniciadi/bomb-game-app.git)
    ```
2.  **Android Studio**'yu açın ve `File > Open` menüsünden projeyi seçin.
3.  Gradle senkronizasyonunun bitmesini bekleyin.
4.  Bir Emulator seçin veya fiziksel cihazınızı bağlayın.
5.  ▶️ **Run** tuşuna basarak oyunu başlatın.

## 🤝 Katkıda Bulunma

Katkılarınızı bekliyoruz! Eğer bir hata bulursanız veya yeni bir özellik eklemek isterseniz:

1.  Bu projeyi Fork'layın.
2.  Yeni bir Branch oluşturun (`git checkout -b feature/YeniOzellik`).
3.  Değişikliklerinizi Commit'leyin (`git commit -m 'Yeni özellik eklendi'`).
4.  Branch'inizi Push'layın (`git push origin feature/YeniOzellik`).
5.  Bir **Pull Request** oluşturun.

## 📄 Lisans

Bu proje [MIT Lisansı](LICENSE) altında lisanslanmıştır.
