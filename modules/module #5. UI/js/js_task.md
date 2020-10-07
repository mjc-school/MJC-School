# READING

1. [JS documentation](https://developer.mozilla.org/en-US/docs/Web/JavaScript)
2. [JS video by net ninja](https://www.youtube.com/c/TheNetNinja/playlists)
3. [Неплохое руководство на русском языке](https://learn.javascript.ru/)
4. [JS tests](https://jestjs.io/ru/)
5. [JavaScript essentials](https://www.linkedin.com/learning/javascript-essential-training-3/)
6. [Event phases](https://www.smashingmagazine.com/2013/11/an-introduction-to-dom-events/)
7. [Event loop](https://www.youtube.com/watch?v=8aGhZQkoFbQ)
8. [DOM Events (lecture)](https://youtu.be/1Z2FYFZ_trI)

# PRACTICE
## Example

![](media/js_dom_task_demo.gif)

## Task 1

1. [install Node.js](https://nodejs.org/en/)
2. You are able to work in any IDE, you want, but we suggest you to use [WebStorm](https://www.jetbrains.com/ru-ru/webstorm/) or [VS code](https://code.visualstudio.com/).
3. Before implementation create empty project and copy a practical task from this module ![js_practical_task.js](media/js_practical_task.js) in it (or you can fork this repository). You can choose how to proof, that your solution works by yourself. (For example: to cover methods with unit tests. this item will be scored additionally)

## Task 2

Based on a previously created HTML template you need to add some  interactive elements to your page:
1. Infinite items (certificates) scroll
2. Search by name, description and tags
3. Scroll back to top button
4. Feature to return to the last scroll position on the page

### Application requirements

1. Save all data in the local storage
2. Data is ordered by creation date by default, newly added item should be on the top
3. Perform search by clicking on the tag or when user stop typing in the input
4. DOM manipulation should be performed on native js
5. Use `_.debounce()` or `_.throttle()` for scroll event handler to optimize your api requests in the future

# DEMO
## Practical part

Mentee should be able to demonstrate his test project.

## Theoretical part

Mentee should be able to answer questions during demo session.