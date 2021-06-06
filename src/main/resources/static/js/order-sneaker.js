(() => {
    window.addEventListener('click', e => {
        let orderButton = e.target.closest('.order-button');
        if (orderButton !== null) {
            const sneakerId = orderButton.dataset.targetSneaker;
            const submitOrder = document.querySelector('#orderSubmit');
            const orderInput = document.querySelector('#orderInput');
            const orderError = document.querySelector('#orderError');

            $('#orderModal').modal('show');

            submitOrder.addEventListener('click', e => {
                orderError.textContent = '';
                const quantity = orderInput.value;

                if (quantity < 0 || quantity > 20000) {
                    orderError.textContent = 'Invalid quantity, input between 0 and 20000';
                }

                fetch('/sneakers/order', {
                    method: 'POST',
                    mode: 'cors', // no-cors, *cors, same-origin
                    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
                    credentials: 'same-origin', // include, *same-origin, omit
                    body: JSON.stringify({ quantity, sneakerId }),
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                    .then(response => response.ok ? response.text() : response.text().then(err => Promise.reject(err)))
                    .then(response => location.reload())
                    .catch(err => {
                        orderError.textContent = err
                    });
            });
        }
    })
})();