
// When using a nullable type, the ?. or !! operators have to be used to access the nullable variable. 


Using ?. avoids a crash by returning null should showAnswerButton be null for some reason.

showAnswerButton?.setOnClickListener { /* */ }
This is equivalent to the following code in Java:

if (showAnswerButton != null) {
    showAnswerButton.setOnClickListener(/* */);
}
The !! operator would cause a crash in the following code if showAnswerButton were null:

showAnswerButton!!.setOnClickListener { /* */ }