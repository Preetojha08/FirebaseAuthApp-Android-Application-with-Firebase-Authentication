# Android Application with Firebase Authentication, Shared Preferences, and Theme Support

This Android application demonstrates user authentication and data retrieval using Firebase Cloud Firestore and Shared Preferences for seamless login persistence. Built with Java and the latest version of Gradle in Android Studio, the app includes a dynamic dark/light theme adaptation based on the system preference.

## Features

### 1. User Authentication
- **Login Activity**: Users can log in by entering their username and password. Credentials are verified against Firebase Cloud Firestore.
- **Registration Activity**: New users can register by navigating to the registration screen and creating an account. After registration, users are redirected to the login screen.
- **Persistent Login**: Login details are stored using Shared Preferences, allowing users to bypass login until they explicitly log out.

### 2. Data Retrieval and Display
- After a successful login, user details are fetched from Firebase Cloud Firestore and displayed on the Home Screen Activity.
- The app automatically fetches and displays stored details on app reopen if the user hasn’t logged out.

### 3. Theme Support
- The app dynamically adapts to the device's dark or light theme preferences, offering a modern and user-friendly experience.

### 4. Gradle and Libraries
- Built with the latest version of Gradle for optimal performance and compatibility.
- Firebase dependencies are included for authentication and database integration.

## Screens and Navigation Flow

### 1. Login Activity
- **Fields**: Username, Password
- **Button**: Login
- **Link**: Register (navigates to Registration Activity)
- Verifies user credentials with Firebase and navigates to the Home Screen upon successful authentication.

### 2. Registration Activity
- **Fields**: Username, Password, Email, etc. (customizable based on use case)
- **Button**: Register
- Registers the user in Firebase and redirects to the Login Activity.

### 3. Home Screen Activity
- Displays user details fetched from Firebase.
- Includes a Logout option that clears Shared Preferences and redirects to the Login Activity.

## Technical Highlights

### Firebase Integration
- **Authentication**: Securely verifies user credentials.
- **Cloud Firestore**: Stores and retrieves user data efficiently.

### Shared Preferences
- User credentials and essential data are stored locally to ensure a smooth user experience without repetitive login.

### Dynamic Theme Support
- Detects the device's theme preference and adjusts the UI accordingly.

## Prerequisites

### Tools and Environment
- Android Studio (latest version)
- Java Development Kit (JDK 11 or later)
- Gradle (latest version)

### Firebase Setup
1. Create a Firebase project at Firebase Console.
2. Add the app's SHA-1 key to Firebase for authentication.
3. Download the `google-services.json` file and place it in the `app/` directory.

## Setup and Installation

1. Clone this repository:

    ```bash
    git clone https://github.com/your-username/your-repo-name.git
    cd your-repo-name
    ```

2. Open the project in Android Studio.
3. Sync the Gradle files to install dependencies.
4. Add your `google-services.json` file to the `app/` folder.
5. Run the project on an emulator or physical device.

## Dependencies

Add the following dependencies to your `build.gradle` file:

```gradle
dependencies {
    implementation platform('com.google.firebase:firebase-bom:32.2.0')
    implementation 'com.google.firebase:firebase-auth'
    implementation 'com.google.firebase:firebase-firestore'
    implementation 'androidx.preference:preference:1.2.1'
}
```
## Screenshots

Login Screen | Registration Screen | Home Screen 
------------ | ------------- | ------------- 
![0](https://github.com/user-attachments/assets/36e382ad-1950-4da1-897d-e9ae6eefc56e) | ![1](https://github.com/user-attachments/assets/ea9ad881-7df1-49c0-8284-ce0a539db876) | ![2](https://github.com/user-attachments/assets/17f4d91f-51e8-4841-9c6d-20dc424f0c3f) 

## Future Enhancements

- Integration with biometric authentication (fingerprint/face unlock).
- User profile management (e.g., updating profile pictures).
- Additional security measures like two-factor authentication.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact

For queries or suggestions, feel free to contact **Preet Ojha** at [developer.preetojha08@gmail.com](mailto:developer.preetojha08@gmail.com).
