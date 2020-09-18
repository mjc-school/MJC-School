# Javascript

This submodule is also devided into 2 part. 
1. JS core
1. working with DOM using JS.

### 1. JS core
* First of all you have to [install Node.js](https://nodejs.org/en/)

* You are able to work in any IDE, you want, but we suggest you to use [WebStorm](https://www.jetbrains.com/ru-ru/webstorm/) or [VS code](https://code.visualstudio.com/).

Before implementation create empty project and copy practical task from *module #4. Angular\js\js_practical_task.js* in it (or you can fork this repository)

You can choose how to proof, that your solution works by yourself. (For example: to cover methods with unit tests. this item will be scored additionally)

### Materials (Videos & Links)

- [JS documentation](https://developer.mozilla.org/en-US/docs/Web/JavaScript)
- [JS video by net ninja](https://www.youtube.com/c/TheNetNinja/playlists)
- [Неплохое руководство на русском языке](https://learn.javascript.ru/)
- [JS tests](https://jestjs.io/ru/)

### 2. JS DOM
   Based on a previously created HTML template you need to add some  interactive elements to your page:
   - Infinite items (certificates) scroll
   - Search by name, description and tags
   - Scroll back to top button
   - Feature to return to the last scroll position on the page
### Requirements:
   - Save all data in the local storage
   - Data is ordered by creation date by default, newly added item should be on the top
   - Perform search by clicking on the tag or when user stop typing in the input
   - DOM manipulation should be performed on native js
   - Use `_.debounce()` or `_.throttle()` for scroll event handler to optimize your api requests in the future
### Result example:
![](js_dom_task_demo.gif) 
### Useful links
- [JavaScript essentials](https://www.linkedin.com/learning/javascript-essential-training-3/)
- [Event phases](https://www.smashingmagazine.com/2013/11/an-introduction-to-dom-events/)
- [Event loop](https://www.youtube.com/watch?v=8aGhZQkoFbQ)
- [DOM Events (lecture)](https://youtu.be/1Z2FYFZ_trI)
