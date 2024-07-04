# PRAKTIKA TESTING

## Task description
<div>Please download our app from Google Play on your mobile device or emulated device.
We request you to cover the following test case using automated tests:</div>
<div>
<ol>
<li>Click “Get started.”</li>
<li>Go through onboarding to the language selection screen.</li>
<li>Change the language.</li>
</ol>
</div>

<div>Please feel free to include assertions and drivers for either an emulator or a real device.
Utilise universal locators for elements wherever possible.</div>

## Technical requirements:

<div>
<ul>
<li>Use Appium for mobile automation.</li>
<li>Implement the test case in Java.</li>
<li>Ensure your code follows best practices for readability and maintainability.</li>
<li>Use a Page Object Model (POM) design pattern.</li>
<li>Provide detailed comments and documentation within the code.</li>
<li>Use a test framework.</li>
<li>Include error handling and reporting for failed test cases.</li>
<li>Demonstrate the use of assertions to validate test outcomes.</li>
</ul>
</div>

## Instructions for the solution provided

<div>
<ul>
<li>Install Java 17 and set $JAVA_HOME</li>
<li>Install maven 3.8.5</li>
<li>Install nvm to the latest version available and set $PATH accordingly</li>
<li>Use nvm to install NodeJS 19.4.0</li>
<li>Install android SKD and tools 35.0.0, set android env variables</li>
<li>Install appium 2.11.1</li>
<li>Install appium inspector</li>
<li>Install uiautomator2 driver</li>
<li>Install allure CLI 2.29.0</li>
<li>Clone repository</li>
<li>Obtain Praktika APK v3.13.0 (e.g. from APK Pure)</li>
<li>Place apk under src/test/resources</li>
<li>Change constant APK_PATH to reflect apk path or name, if needed</li>
<li>Launch appium server</li>
<li>Create new android emulator:</li>
<code>avdmanager create avd --name "praktikaEmulator" --package "system-images;android-35;google_apis;x86_64" --abi "x86_64"
</code>
<li>Launch android emulator: <b>emulator -avd praktikaEmulator -no-boot-anim -wipe-data</b></li>
<li>Once emulator is finished loading, open an appium inspector session on it 
(this is to prevent the first test to fail due to a timeout caused by appium installation)
You can use the following JSON Representation:</li>
<code>
{<br>
  "platformName": "Android",<br>
  "appium:automationName": "UiAutomator2",<br>
  "appium:appPackage": "ai.praktika.android",<br>
  "appium:appActivity": ".MainActivity",<br>
  "appium:disableIdLocatorAutocompletion": true,<br>
  "appium:app": "/absolute/path/to/apk/praktika.apk"<br>
}
</code>
<li>cd to the root of the project</li>
<li>execute the following as a block of code:</li>
<code>
mvn clean verify -P android<br>
mkdir -p allure-results/history<br>
cp -r allure-report/history/* allure-results/history/<br>
allure generate allure-results --clean -o allure-report<br>
allure serve
</code>
</ul></div>

<div>In case of issues, contact <b>javieraguerrimoreno@gmail.com</b></div>
