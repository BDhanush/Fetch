# Fetch - Android Internship Coding Exercise
[Problem document](https://fetch-hiring.s3.amazonaws.com/mobile.html)

Use the following apk link to download the app apk or open this repository using android studio and build the apk. <br>
[APK link](https://1drv.ms/u/s!AmvH0VCG4AMoiugpZLirSBopUo8T7Q?e=IK1Jj3)

Flow:
1. An http get request is made to get the items.
2. A list of items is received in the response body.
3. Dataset is filtered according to requirements.
4. Recycler view is filled with dataset.

Activities:
  1. MainActivity:
      - makes http get call to get all the items
      - filters the items based on the requirements
      - contains a recycler view that displays all the items

Layouts:
  1. activity_main:
      - contains a circular progress bar and a recycler view
  2. item:
      - view to display each individual item

ApiInterface:
  - uses retrofit library to make api calls

ListingAdapter:
  - adapter used for recycler view
  - sets the values of id, listId, name for item view in onBindViewHolder()
