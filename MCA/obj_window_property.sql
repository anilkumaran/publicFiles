Object / Window Properties in WinRunner
✅ Definition

Object/Window properties are the attributes of a GUI object (like button, textbox, window, list box, etc.) that uniquely describe it so that WinRunner can recognize it during playback.

They are stored in the GUI Map (WinRunner’s object repository).

📌 Types of Properties
1. Mandatory Properties

Basic properties that WinRunner always learns automatically to identify an object.

Examples:

For a button → label, type.

For a window → title, class.

2. Optional Properties

Used if mandatory properties are not sufficient to uniquely identify an object.

Examples:

width, height, color, enabled.

WinRunner can be configured to learn optional properties.

3. Ordinal Identifier

If both mandatory and optional properties are not enough, WinRunner assigns an ordinal number (like index) to distinguish between similar objects.

Example: Two buttons with label "OK", WinRunner may use index=0 and index=1.

4. User-defined Properties

Tester can define custom properties to better identify objects (when built-in ones are not enough).

📌 Examples
Example 1: Button Object
Logical Name: Login_Button
Physical Description:
{
   class : push_button,
   label : "Login",
   enabled : 1,
   x : 150,
   y : 200
}


Properties here: class, label, enabled, x, y

WinRunner uses these to find and click the "Login" button.

Example 2: Window Object
Logical Name: Flight Reservation
Physical Description:
{
   class : window,
   title : "Flight Reservation",
   width : 600,
   height : 400
}


Properties here: class, title, width, height.

Used to identify the correct application window.

📌 Why Properties are Important

Without properties, WinRunner won’t know which object to interact with.

Ensures object recognition is stable even if screen layout changes.

Reduces script failures when UI changes slightly.

📌 Where Properties are Stored

In the GUI Map file:

Logical Name (used in script, e.g., Login_Button)

Physical Description (actual properties used for recognition).

Example in TSL Script:

button_press("Login_Button");


👉 Here "Login_Button" is the logical name. WinRunner looks it up in the GUI Map, finds its properties, and locates the button in the AUT.

✅ Summary

Object/Window Properties = attributes that uniquely identify GUI objects.

Stored in GUI Map as Physical Description.

Types: Mandatory, Optional, Ordinal, User-defined.

Critical for object recognition in automation.
