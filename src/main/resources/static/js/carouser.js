const CLICK_SCROLL_OFFSET = 400;
(function init() {

    const leftArrow = document.querySelector('.arrow.left');
    const rightArrow = document.querySelector('.arrow.right');

    leftArrow.addEventListener('click', offsetLeft);
    rightArrow.addEventListener('click', offsetRight);
})();

function offsetLeft(evt) {
    offset('left');
}

function offsetRight(evt) {
    offset('right');
}

function offset(direction) {
    const carousel = document.querySelector('.carousel-content');
    const currentLeftScroll = carousel.scrollLeft;

    let scrollOffset = direction === 'right' ? CLICK_SCROLL_OFFSET : -CLICK_SCROLL_OFFSET;

    const targetScroll = currentLeftScroll + scrollOffset;
    let start;

    function step(t) {
        if (!start) {
            start = t;
        }

        const elapsed = t - start;
        const scrollLeft = carousel.scrollLeft;
        const maxScrollWidth = carousel.scrollWidth - carousel.clientWidth;

        if (direction === 'right') {
            if (scrollLeft < targetScroll && scrollLeft < maxScrollWidth) {
                carousel.scrollLeft += (0.1 * elapsed);
                requestAnimationFrame(step);
            }
        } else {
            if (scrollLeft > targetScroll && scrollLeft > 0) {
                carousel.scrollLeft -= (0.1 * elapsed);
                requestAnimationFrame(step);
            }
        }

    }


    requestAnimationFrame(step);
}

