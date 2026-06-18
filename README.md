# Automation Framework

A multi-platform test automation framework built with Java, Cucumber, Appium, Selenium, and RestAssured. Supports Android mobile, Web, and API testing.

---

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)

---

## Prerequisites

Install the following tools before running any tests.

### 1. Java Development Kit (JDK) 21
Required to compile and run the project.

- Download: https://www.oracle.com/java/technologies/downloads/#java21
- Verify installation:
  ```
  java -version
  ```
  Expected output: `java version "21.x.x"`

### 2. Android Studio
Required to run the Android emulator and provides the Android SDK.

- Download: https://developer.android.com/studio
- During setup, ensure the following SDK components are installed via **SDK Manager**:
  - Android SDK Platform-Tools
  - Android Emulator
  - At least one Android SDK Platform (e.g., API 36)

### 3. Node.js
Required to install and run Appium.

- Download: https://nodejs.org (LTS version recommended)
- Verify installation:
  ```
  node -v
  npm -v
  ```

### 4. Appium
Required to communicate between the test framework and the Android emulator.

- Install via npm:
  ```
  npm install -g appium
  ```
- Install the UIAutomator2 driver:
  ```
  appium driver install uiautomator2
  ```
- Verify installation:
  ```
  appium -v
  ```

### 5. Environment Variables
Set the following environment variables so Appium can locate the Android SDK.

**Windows:**
1. Open **System Properties** → **Environment Variables**
2. Under **User variables**, add:

   | Variable | Value |
   |----------|-------|
   | `ANDROID_HOME` | `C:\Users\<your-username>\AppData\Local\Android\Sdk` |
   | `ANDROID_SDK_ROOT` | `C:\Users\<your-username>\AppData\Local\Android\Sdk` |

3. Add the following to **Path**:
   ```
   %ANDROID_HOME%\platform-tools
   %ANDROID_HOME%\emulator
   %ANDROID_HOME%\tools
   ```

4. Verify:
   ```
   adb --version
   ```

---

## Installation

### 1. Clone the repository
```
git clone <repository-url>
cd automation-framework
```

### 2. Download the APK
Download `mda-2.2.0-25.apk` from the GitHub releases page and place it in the `apps/` folder:
```
automation-framework/
└── apps/
    └── mda-2.2.0-25.apk
```
APK source: https://github.com/saucelabs/my-demo-app-android/releases

### 3. Create an Android Virtual Device (AVD)
1. Open **Android Studio** → **Device Manager**
2. Click **Create Device**
3. Select a device (e.g., Medium Phone)
4. Select a system image (e.g., API 36)
5. Finish and start the emulator
6. Verify the emulator is detected:
   ```
   adb devices
   ```
   Expected output:
   ```
   List of devices attached
   emulator-5554   device
   ```

---

## Project Structure

```
automation-framework/
├── apps/
│   └── mda-2.2.0-25.apk                  # Android APK under test
├── src/test/
│   ├── java/
│   │   ├── hooks/
│   │   │   └── Hooks.java                 # Before/After scenario hooks
│   │   ├── pages/
│   │   │   └── android/                   # Page Object Model classes
│   │   │       ├── LoginPage.java
│   │   │       ├── ProductCatalogPage.java
│   │   │       ├── ProductDetailPage.java
│   │   │       ├── HeaderPage.java
│   │   │       ├── CartPage.java
│   │   │       ├── ShippingAddressPage.java
│   │   │       ├── PaymentPage.java
│   │   │       ├── ReviewOrderPage.java
│   │   │       └── CheckoutCompletePage.java
│   │   ├── runners/
│   │   │   └── AndroidRunner.java         # Test suite runner
│   │   ├── stepDefinitions/
│   │   │   └── android/                   # Step definitions per page
│   │   │       ├── LoginSteps.java
│   │   │       ├── ProductCatalogSteps.java
│   │   │       ├── ProductDetailSteps.java
│   │   │       ├── CartSteps.java
│   │   │       ├── ShippingAddressSteps.java
│   │   │       ├── PaymentSteps.java
│   │   │       ├── ReviewOrderSteps.java
│   │   │       └── CheckoutCompleteSteps.java
│   │   └── utils/
│   │       ├── AppiumManager.java         # Android driver manager
│   │       ├── ConfigReader.java          # Reads config.properties
│   │       └── DriverManager.java         # Web driver manager
│   └── resources/
│       ├── features/
│       │   └── android/
│       │       ├── login.feature
│       │       ├── buy_product.feature
│       │       └── sort_product.feature
│       └── config.properties              # Test configuration
└── build.gradle                           # Dependencies and build config
```

---

## Configuration

All configuration is in `src/test/resources/config.properties`:

```properties
# Android
app.path=apps/mda-2.2.0-25.apk
app.package=com.saucelabs.mydemoapp.android
app.activity=com.saucelabs.mydemoapp.android.view.activities.SplashActivity
device.name=emulator-5554
appium.url=http://127.0.0.1:4723
```

| Property | Description |
|----------|-------------|
| `app.path` | Relative path to the APK file |
| `app.package` | Android app package name |
| `app.activity` | Launch activity of the app |
| `device.name` | Emulator or device name from `adb devices` |
| `appium.url` | Appium server URL |

---

## Running Tests

### Step 1 — Start the Android emulator
Open Android Studio → Device Manager → click the **Play** button on your AVD.

### Step 2 — Start the Appium server
Open a terminal and run:
```
set ANDROID_HOME=C:\Users\<your-username>\AppData\Local\Android\Sdk
set ANDROID_SDK_ROOT=C:\Users\<your-username>\AppData\Local\Android\Sdk
appium
```
Wait until you see:
```
Appium REST http interface listener started on http://0.0.0.0:4723
```

### Step 3 — Run the tests
Open a second terminal in the project root and run:

```
# Run all Android tests
.\gradlew.bat test --tests "runners.AndroidRunner"

# Run only login test
.\gradlew.bat test --tests "runners.AndroidRunner" -Dcucumber.filter.tags="@login"

# Run only buy product test
.\gradlew.bat test --tests "runners.AndroidRunner" -Dcucumber.filter.tags="@buy"

# Run only sort tests
.\gradlew.bat test --tests "runners.AndroidRunner" -Dcucumber.filter.tags="@sort"
```

### Available Tags

| Tag | Scenario |
|-----|----------|
| `@login` | Successful login with valid credentials |
| `@buy` | Buy Sauce Labs Backpack — blue, quantity 2, full checkout |
| `@sort` | Sort products by Name Descending and Price Ascending |

---

## Test Reports

After running tests, HTML reports are generated at:
```
build/reports/cucumber/android.html
```
Open the file in a browser to view detailed results per scenario and step.
