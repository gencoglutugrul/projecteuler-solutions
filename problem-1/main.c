/**
 * GNU/Linux üzerinde gcc 10.2.0
 * kullanılarak derlenmiştir.
 */
#include "stdio.h"


/**
 * Karmaşıklık: O(n)
 * 
 * İlk akla gelen ve en kötü olan çözüm: 
 * n'e kadar olan sayıları gezerek
 * bunların 3'e ve 5'e bölünürlüğünü 
 * kontrol ederek toplamlarını almak.
 */
int iterate_n_times(int n){
    int sum = 0;
    for (int i = 3; i < n; i++){
        if(i % 3 == 0 || i % 5 == 0)
            sum += i;
    }
    
    return sum;
}

/**
 * Karmaşıklık: O(n)
 * 
 * İlk çözümü biraz optimize edersek
 * farkediyoruz ki aslında n/3 e kadar
 * olan sayıları gezmemiz yeterli olacak.
 */
int iterate_optimized(int n){
    int sum = 0;
    for (int i = 1; i <= n/3; i++){
        sum += 3*i;

        // 5* [3, n/3] aralığında n'i geçecek sayıları atılıyoruz.
        // dikkat edeceğimiz nokta 3'e ve 5'e bölünen sayıları iki kez
        // toplama dahil etmemek.
        if( i % 3 != 0 && 5*i < n)
            sum += 5*i;
    }
    
    return sum;
}

/**
 * Karmaşıklık O(1)
 * 
 * Probleme daha dikkatli baktığımızda 
 * görüyoruz ki hiç iterasyona ihtiyacımız yok.
 * Aslında bunların tamamı ardışık sayıların
 * bir çeşit toplamı. Gauss toplam formülü ile
 * kolayca çözülebilir.
 * 
 * Bir üstteki çözümden anladığımız gibi yapmamız 
 * gereken [3, n/3] aralığındaki tam sayıları toplamak
 * ve 3 ile çarpmak. Sonra aynısını 5 için yapıp onu da 
 * toplama eklemek.
 */
int solve_by_gauss_formula(int n){
    // soru kuralına göre n'in altındaki bölünebilenler 
    // dahil edilmeli. Örneğin n=10 için sadece 5 var
    // 5 ve 10 değil. 10 un dahil olmaması için n'i 9 alıyoruz.
    // Tamsayı bölmesi yaptığımız için değişen veya bozulan 
    // hiçbir şey olmayacak.
    n = n - 1;

    int sum = 3 * (n/3) * (n/3 + 1) / 2;
    sum += 5 * (n/5) * (n/5 + 1)  / 2;
    
    // 3 ve 5'in ortak katları yani 15'in katları ikişer defa
    // sayıldı. Bunları çıkartalım.
    sum -= 15 * (n/15) * (n/15 +1) /2;
    
    return sum;
}

int main(){
    printf("sonuc: %d\n", solve_by_gauss_formula(1000));
    printf("sonuc: %d\n", iterate_optimized(1000));
    printf("sonuc: %d\n", iterate_n_times(1000));
    
    return 0;
}