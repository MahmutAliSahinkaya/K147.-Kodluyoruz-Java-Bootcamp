# Emlak İlan Sistemi
Spring Boot  Project

 <a href="https://dev.java/" rel="nofollow"> <img src="https://camo.githubusercontent.com/4516a1dca56d6cc15e4102e39acf0c139cc69f220d05b9136af0dfece96a3dfd/68747470733a2f2f75706c6f61642e77696b696d656469612e6f72672f77696b6970656469612f74722f322f32652f4a6176615f4c6f676f2e737667" alt="nodejs" width="40" height="40" data-canonical-src="https://upload.wikimedia.org/wikipedia/tr/2/2e/Java_Logo.svg" style="max-width: 100%;"> </a> <a href="https://spring.io/" rel="nofollow"> <img src="https://camo.githubusercontent.com/4545b55c7771bbd175235c80b518dcbbf2f6ee0b984a51ad9363cba8cb70e67c/68747470733a2f2f7777772e766563746f726c6f676f2e7a6f6e652f6c6f676f732f737072696e67696f2f737072696e67696f2d69636f6e2e737667" alt="spring" width="40" height="40" data-canonical-src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" style="max-width: 100%;"> </a> <a href="https://www.postgresql.org" rel="nofollow"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="40" height="40" style="max-width: 100%;"> </a> <a href="https://postman.com" rel="nofollow"> <img src="https://camo.githubusercontent.com/93b32389bf746009ca2370de7fe06c3b5146f4c99d99df65994f9ced0ba41685/68747470733a2f2f7777772e766563746f726c6f676f2e7a6f6e652f6c6f676f732f676574706f73746d616e2f676574706f73746d616e2d69636f6e2e737667" alt="postman" width="40" height="40" data-canonical-src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" style="max-width: 100%;"> </a>


## PROJE DIAGRAM

![emlakcepteDiagram](https://user-images.githubusercontent.com/107810135/211197279-56ee02bf-090a-4ec6-9032-9a08f66ad9a8.png)


 ```
  - Java 17
  - Maven
  - Java Spring Boot
  - Postman
  - PostgreSQL
  - RabbitMQ
  ```


<hr>

## PROJE KONUSU

Emlak İlan Sistemi
Proje Konusu:
Bir emlak ilan sistemi için, kullanıcıların sistem üzerinden ilan oluşturabildiği, ilanları düzenleyebildiği, 
ilanları silebildiği ve ilanların detaylarına ulaşabildiği ayrıca kendi ilanlarını aktif ve pasif duruma getirebildiği
ve paket satın alıp kendi ilanları için kullanabildiği bir uygulamanın Spring Boot framework kullanılarak yazılması.

Ürün: İlan yayınlama hakkı
- Paket, 10 adet ilan yayınlama hakkı içerir, bir aylık geçerlilik süresi vardır. Paketi olmayan veya paketin geçerlilik
süresi bitmiş kullanıcılar ilan yayınlayamazlar. Kullanıcılar paket geçerliliği dolmadan yeni paket alabilir. Bu durumda
yeni geçerlilik tarihi, kalan geçerlilik tarihinin üzerine bir ay olarak eklenerek bulunmalıdır.

## Gereksinimler:

- İlan yayınlama işlemini sadece sisteme giriş yapan kullanıcı yapabilmeli.
- Aktif ilanlarını görüntüleyebilmeli.
- Pasif ilanlarını görüntüleyebilmeli.
- Satın aldıkları paketleri(ürünleri) görebilmeli.
- Kullanıcılar ilanları sadece ACTIVE ve PASSIVE statülerine güncelleyebilmeli.
- Kullancıların aldıkları ürünler ödeme işlemi başarılı olduktan sonra tanımlanmalı ve bu işlem asenkron yapılmalı.
 <br>

## Sistem Kabulleri:

- Ürünler, yukarıda belirtilen şekilde sistemde hali hazırda tanımlıdır. Ürün
  oluşturmak için yeni bir servis yazımına gerek yoktur. Sistem içerisinde
  tanımlanmaları yeterlidir.
- Ürünler adet bazlı satılmaktadır.
- Ürünler 10’ar adet olarak satın alınabilmektedir.
- Ürünün geçerlilik 1 ay yani 30 gün ile sınırlıdır.
- Ödeme işlemi için sisteme gerekli kayıtların yazılması yeterlidir.
- Ödeme işlemi senkron yapılmalıdır.
- İlanlar varsayılan olarak kaydedildiğinde IN_REVIEW statüsündedir. Asenkron
  olarak başka bir servis ACTIVE olarak değiştirmelidir.
-  Kullanıcılar ilanları sadece ACTIVE ve PASSIVE statülerine güncelleyebilir.

## İlanın Statüleri:

- ACTIVE
- PASSIVE
- IN_REVIEW

  <br>

<hr>

## Proje Kullanım Akışı <br>

* İlk etapta Discovery Server ayağa kaldırılır ve böylece Eureka yani bağlı olduğumuz microservislerin ayakta 
olanlarının portlarını rahat bir şekilde görebiliriz.

![EurekaServer](https://user-images.githubusercontent.com/107810135/211197298-c6573f75-5de9-455f-815e-aebdb4c26258.png)

 <hr>

* İkinci olarak Api-Gateway ayağa kaldırılır.


<hr>

## Postman Üzerinden Atılan İsteklere Örnekler;

![products-post](https://user-images.githubusercontent.com/107810135/211197308-8993144b-faec-412f-b9ce-a253fb7b7c7b.png)

![products-get](https://user-images.githubusercontent.com/107810135/211197310-1722be40-85c2-4a32-a600-1dbcc4e0dcf8.png)

![users-post](https://user-images.githubusercontent.com/107810135/211197315-0b150ed7-fd3a-4720-a2bb-a4252f560dfb.png)

![users-get](https://user-images.githubusercontent.com/107810135/211197322-05a493ae-f753-4719-9d35-2bb554da8bc8.png)

![users-getAll](https://user-images.githubusercontent.com/107810135/211197329-b7e015f3-046d-4498-a76c-6bb5f3742eaa.png)


<br><hr>

## Postgres Üzerinde Oluşan Tablolar;

![postgres-tablolar](https://user-images.githubusercontent.com/107810135/211197337-e8f8e719-d5b0-4382-9416-486f104ba70f.png)







