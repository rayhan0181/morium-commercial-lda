# Warehouse Billing Android app — source project

Features: manually add product names and selling prices; search products; create bills with customer name/phone, quantities, discounts, paid and balance amounts; local bill history; CSV export; print/save as PDF. Currency is Mozambique Metical (MT). The app is English-only and stores data locally on the device using browser local storage.

## Build the APK
1. Install Android Studio on a computer and install Android SDK Platform 35 (or choose an installed SDK and adjust `compileSdk` in `app/build.gradle`).
2. Open this folder (`WarehouseBillingApp`) in Android Studio.
3. Let Gradle sync and wait for dependencies to download.
4. Select **Build → Build Bundle(s) / APK(s) → Build APK(s)**.
5. Android Studio will show the generated APK location, usually `app/build/outputs/apk/debug/app-debug.apk`.
6. Copy the APK to your Android phone and install it. If prompted, allow installation from that source.

For a release APK, use **Build → Generate Signed Bundle / APK** and create a signing key. Keep the key safe for future updates.

## Notes
- This is a source project, not a precompiled APK. A compatible Android SDK/Gradle build environment is required to compile it.
- Data is stored on the phone, not in a cloud account. Export CSV backups regularly.
- Product prices and bill totals are in MT. Test printing/PDF on your phone before relying on it for business records.
