# dsr-junior-developer-task

I assigned this task to test knowledge of Junior developor in my company. This project covers the task which is coded by me.

# Task

Level: Easy

Create an Android application that displays information received over the network.

It needs to have 2 screens:  

In Screen1, get products over API and display them using a pagination pattern. Display title, price, and image. When a product gets clicked, navigate it to Screen2. In Screen2, display title, description, price, rating, stock, brand, image.

API -> https://dummyjson.com/docs/products

Requirements:

1. Use Android Jetpack libraries.
2. Use Android best practices.
3. Apply MVVM architectural pattern.
4. Use Pagination pattern: first load 24 products, then continuously load 8 by 8 when it is scrolled to the bottom.
5. Apply SOLID design principles.

# Requirements Check:

1. Used the latest native Android app development tech stack inlcuding all the best practices and libraries that comes from Android Jetpack. To name some of them, Jetpack Navigation Components, Jetpack Paging3, Jetpack Dagger Hilt, Jetpack SavedStateHandle, Jeptack ViewModel, Jetpack Lifecycle and so on.
2. Followed all best practices in the project.
3. Applied Clean Architecture architectural pattern which includes MVVM. Clean Architecture includes additional design patterns such as Repository, UseCase, Mapper (DTO-Model), Dependency Injection, and so on.
4. Pagination pattern is achieved via Jetpack Paging 3.1 library as it is Android best practice. I made it first load 24 items and then lazily load 8 by 8 when scrolled to bottom or top. Also, there is Header and Footer that shows progress bar when loading. When items reach 8 * 6 = 48, it starts destroying oldest items as they occupy unnecessary space in Android RAM (best practise).
5. SOLID design pattern is followed.
