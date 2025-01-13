# Android Application with Firebase Authentication, Shared Preferences, and Theme Support

This Android application demonstrates user authentication and data retrieval using Firebase Cloud Firestore and Shared Preferences for seamless login persistence. Built with Java and the latest version of Gradle in Android Studio, the app includes a dynamic dark/light theme adaptation based on the system preference.

---

## Features

### User Authentication
- **Login Activity**: Users can log in by entering their username and password. Credentials are verified against Firebase Cloud Firestore.
- **Registration Activity**: New users can register by navigating to the registration screen and creating an account. After registration, users are redirected to the login screen.
- **Persistent Login**: Login details are stored using Shared Preferences, allowing users to bypass login until they explicitly log out.

### Data Retrieval and Display
- After a successful login, user details are fetched from Firebase Cloud Firestore and displayed on the **Home Screen Activity**.
- The app automatically fetches and displays stored details on app reopen if the user hasn’t logged out.

### Theme Support
- The app dynamically adapts to the device's dark or light theme preferences, offering a modern and user-friendly experience.

---

## Screens and Navigation Flow

1. **Login Activity**
   - Fields: Username, Password
   - Button: `Login`
   - Link: `Register` (navigates to Registration Activity)
   - Verifies user credentials with Firebase and navigates to the Home Screen upon successful authentication.

2. **Registration Activity**
   - Fields: Username, Password, Email, etc. (customizable based on use case)
   - Button: `Register`
   - Registers the user in Firebase and redirects to the Login Activity.

3. **Home Screen Activity**
   - Displays user details fetched from Firebase.
   - Includes a `Logout` option that clears Shared Preferences and redirects to the Login Activity.

---

## Technical Highlights

- **Firebase Integration**: Secure authentication and data storage/retrieval with Cloud Firestore.
- **Shared Preferences**: Persistent local storage for seamless user experience.
- **Dynamic Theme Support**: Detects and adjusts to the device's dark/light theme preference.

---

## Prerequisites

1. **Tools and Environment**
   - Android Studio (latest version)
   - Java Development Kit (JDK 11 or later)
   - Gradle (latest version)

2. **Firebase Setup**
   - Create a Firebase project at [Firebase Console](https://console.firebase.google.com/).
   - Add the app's SHA-1 key to Firebase for authentication.
   - Download the `google-services.json` file and place it in the `app/` directory.

---
