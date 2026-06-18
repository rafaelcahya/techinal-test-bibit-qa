Feature: Sample Android Automation
  As a tester, I want to verify Android app features

  Scenario: Launch Android application
    Given the Android app "com.example.app" is launched with activity "com.example.app.MainActivity"
    Then the app should be visible on screen
