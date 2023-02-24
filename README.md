# dsr-junior-developer-task

I assigned this task to review knowledge of Junior developor in my company. This project covers the task.

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

# Screenrecordings:

<p align="center">
    <img width="296" height="600" src="https://github.com/raheemadamboev/dsr-junior-developer-task/blob/master/banner_3.gif" >
</p>

In Screen1, title, price, and image displayed. In Screen2, additional details of the product namely title, description, price, rating, stock, brand, image are displayed.

---

<p align="center">
    <img width="296" height="600" src="https://github.com/raheemadamboev/dsr-junior-developer-task/blob/master/banner_1.gif" >
</p>

When user scrolls to bottom, lazyily loads 8 by 8 (Pagination design pattern). Footer progress bar is also displayed that informs the user that it is loading more results.

---

<p align="center">
    <img width="296" height="600" src="https://github.com/raheemadamboev/dsr-junior-developer-task/blob/master/banner_2.gif" >
</p>

When there is more than enough data is loaded, it starts destroying the oldest data in order to free up space in RAM. When scrolled to top to see oldest items, it loads them lazily (Pagination design pattern). Header progress bar is also displayed that informs the user that it is loading more results.

# Tech Stack

- Architectural Pattern: Clean Architecture, MVVM
- UI: XML, Material3
- Dependency Injection: Hilt
- Navigation: Jetpack Navigation Components
- Concurrency: Kotlin Coroutines, Kotlin Flows
- Networking: Retrofit2, Kotlin Serialization
- Pagination: Jetpack Paging3
– Others: ViewBinding, Glide, Timber, Safe Args

# Demo

<a href="https://github.com/raheemadamboev/dsr-junior-developer-task/blob/master/app-debug.apk">You can download demo apk</a>

# Licence

```xml
Designed and developed by raheemadamboev (Raheem) 2023.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
