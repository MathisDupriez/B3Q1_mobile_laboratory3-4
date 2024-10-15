# Question 1
Le ? dans style="?android:listSeparatorTextViewStyle" est utilisé pour référencer un attribut de style défini par le système Android. 
Cela signifie que le style listSeparatorTextViewStyle est un style prédéfini par Android et sera appliqué à l'élément en question.  
Explication :  
- ?android: : Indique que l'attribut de style est défini par le système Android.
- listSeparatorTextViewStyle : Le nom de l'attribut de style spécifique que vous souhaitez appliquer.

# Question 2
## a. Quelle est la classe qui permet d’écouter un TextView ?
La classe qui permet d'écouter un TextView est TextWatcher.
`TextWatcher` is an interface in Android that allows you to listen for changes to the text in an `EditText` or `TextView`. It provides three methods that you can override to respond to different stages of text changes:

1. **beforeTextChanged(CharSequence s, int start, int count, int after)**: This method is called to notify you that the characters within `start` and `start + before` are about to be replaced with new text with length `after`.

2. **onTextChanged(CharSequence s, int start, int before, int count)**: This method is called to notify you that somewhere within `start` to `start + before`, the text has been replaced with new text with length `count`.

3. **afterTextChanged(Editable s)**: This method is called to notify you that somewhere within `start` to `start + before`, the text has been replaced with new text with length `count`.

Here is an example of how to use `TextWatcher`:

```java
EditText editText = findViewById(R.id.edit_text);
editText.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // Code to execute before the text is changed
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // Code to execute when the text is being changed
    }

    @Override
    public void afterTextChanged(Editable s) {
        // Code to execute after the text has been changed
    }
});
```

In this example, the `TextWatcher` is added to an `EditText` to listen for text changes and execute code at each stage of the text change process.

## b.Quelle est la classe qui permet d’écouter un Checkbox ?
La classe qui permet d'écouter un CheckBox est CompoundButton.OnCheckedChangeListener.
`CompoundButton.OnCheckedChangeListener` is an interface in Android that allows you to listen for changes to the checked state of a `CompoundButton`, such as a `CheckBox`, `RadioButton`, or `Switch`. This interface provides a single method that you can override to respond to changes in the checked state.

### Method:
- **onCheckedChanged(CompoundButton buttonView, boolean isChecked)**: This method is called when the checked state of the button has changed. The `buttonView` parameter is the `CompoundButton` whose state has changed, and the `isChecked` parameter is the new checked state of the button.

### Example:
Here is an example of how to use `CompoundButton.OnCheckedChangeListener` with a `CheckBox`:

```java
CheckBox checkBox = findViewById(R.id.checkbox);
checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // Code to execute when the checked state changes
        if (isChecked) {
            // The CheckBox is checked
        } else {
            // The CheckBox is unchecked
        }
    }
});
```

In this example, the `OnCheckedChangeListener` is added to a `CheckBox` to listen for changes in its checked state and execute code accordingly.

