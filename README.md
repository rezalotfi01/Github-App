# Github-App

This is an Android application for exploring Github users detail from API and show it to user with pagination and beautiful animations.

for this app:
- Modular Clean Architecture and MVVM approach followed
- It is heavily implemented by following standard clean architecture principle.
- Unit testing written for APIs, Mappers, Domain, etc.
- [S.O.L.I.D](https://en.wikipedia.org/wiki/SOLID) principle followed for more understandable, flexible and maintainable codes.

## - Screenshots

![](/screenshots/screen1.png)
![](/screenshots/screen2.png)

### Git Branching Model
About the Git branching model, Git Flow approach followed (e.g., Feature|Development|Main and other branches). it makes development process very easier, by isolating new development from finished work.

### Clean Architecture and Why this approach?
1. Separation of code in different layers with assigned responsibilities making it easier for further modification.
2. High level of abstraction
3. Loose coupling between the code
4. Testing of code is painless

### Layers
- **Domain** - Would execute business logic which is independent of any layer and is just a pure kotlin/java package with no android specific dependency.
- **Data** - Would dispense the required data for the application to the domain layer by implementing interface exposed by the domain.
- **Presentation / framework** - Would include both domain and data layer and is android specific which executes the UI logic.

## - Modules of App
### App
It contains all classes of the Presentation/UI layer. This layer's responsibility is to handle the presentation of the User Interface.
Each ViewModel class that is created implements the ViewModel class found within the Architecture components library. This ViewModel used by the UI parts to communicate with UseCases and retrieve data.
It uses the all the components and class related to Android Framework. It gets the data from presentation layer and shows on UI.

### BuildSrc
This module helps to list and manage all the dependencies of the app at one place. It has list of dependencies and versions of that dependencies.

### Data
The Data layer is our access point to external data layers and is used to fetch data from multiple sources (the local and remote in our case).

### Domain
The domain layer responsibility is to simply contain the UseCase instance used to retrieve data from the Data layer and pass it onto the Presentation layer.

### Remote
The Remote layer handles all communications with remote sources, in our case it makes a simple API call using a Retrofit interface.


## Testing

### Unit Testing

There are some highlights:
* Various parts in the architecture has been tested with its mapper|data-adapter|provider.
* Mockito has been used for mocking|stubbing.
* `Given|When|Then` steps have been followed, in order to give a more structured overview.

### UI Testing

I opted for a dynamic test configuration, so it's possible to inject different configurations as peer need.
* In order to mock the responses and use them for instrumentation testing, I've used MockWebServer.


## Tech Stack
* [Kotlin Coroutines and Flows][0] Library support for Kotlin coroutines and asynchronous data streams.
* [Android Jetpack][1] Collection of libraries for designing more robust, testable, and maintainable apps.
* [Paging3][2] for making it easier to load data gradually within the app. it's also synchronized with kotlin flows.
* [Kotlin Flow][4] for reactive style programming.
* [Navigation Component][5] for in-app navigation.
* [Lottie][6] for implementing fancy loading animation in the app.
* [Koin][7] for dependency injection.
* [Retrofit][8] for REST api communication.
* [Timber][9] for logging.
* [Mockito-Kotlin][11] for mocking in tests.
* [Stetho][13] A debug bridge for Android applications, enabling the powerful Chrome Developer Tools and much more.
* [AndroidX Test Library][14] for providing Android framework test functions in the tests
* [Glide][15] Image downloading and caching library

[0]:  https://github.com/Kotlin/kotlinx.coroutines
[1]:  https://developer.android.com/jetpack/androidx/explorer
[2]:  https://developer.android.com/jetpack/androidx/releases/paging
[4]:  https://kotlinlang.org/docs/flow.html
[5]:  https://developer.android.com/topic/libraries/architecture/navigation/
[6]:  https://github.com/airbnb/lottie-android
[7]:  https://insert-koin.io/
[8]:  https://github.com/square/retrofit
[9]:  https://github.com/JakeWharton/timber
[11]: https://github.com/nhaarman/mockito-kotlin
[13]: https://github.com/facebook/stetho
[14]: https://github.com/android/android-test
[15]: https://github.com/bumptech/glide
