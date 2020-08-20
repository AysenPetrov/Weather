

    private void getDataFromFirstActivity() {
        Serializable serializable = getIntent().getSerializableExtra(MainActivity.KEY_TO_CITY);
        if(serializable != null) {
            Parcel parcel = (Parcel)serializable;
            String text = Objects.requireNonNull(parcel).text;
            selectedCity.setText(text);
        }
    }
}
