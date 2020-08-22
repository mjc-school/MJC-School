### Description
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