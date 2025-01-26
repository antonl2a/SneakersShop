(() => {
    window.addEventListener('click', e => {
        let orderButton = e.target.closest('.order-button');
        if (orderButton !== null) {
            const sneakerId = orderButton.dataset.targetSneaker;
            const submitOrder = document.querySelector('#orderSubmit');
            const orderInput = document.querySelector('#orderInput');
            const orderError = document.querySelector('#orderError');
            const orderSuccess = document.querySelector('#orderSuccess');

            $('#orderModal').modal('show');

            submitOrder.addEventListener('click', () => {
                orderError.style.display = 'none'; // Hide error message initially
                orderSuccess.style.display = 'none'; // Hide success message initially

                const quantity = orderInput.value;

                if (quantity < 0 || quantity > 20000) {
                    orderError.textContent = 'Invalid quantity, input between 0 and 20000';
                    orderError.style.display = 'block';
                    return; // Exit early if validation fails
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
                    .then(response => {
                        if (response.ok) {
                            return response.text(); // Get the response text if the request was successful
                        } else {
                            return response.text().then(err => Promise.reject(err)); // Handle server errors
                        }
                    })
                    .then(responseMessage => {
                        orderSuccess.textContent = responseMessage; // Display the success message
                        orderSuccess.style.display = 'block';
                        orderInput.value = ''; // Optionally clear the input field after success

                        // Wait 3 seconds, then refresh the page
                        setTimeout(() => {
                            location.reload();
                        }, 3000); // 3000ms = 3 seconds
                    })
                    .catch(err => {
                        orderError.textContent = err; // Display error messages from the server
                        orderError.style.display = 'block';
                    });
            });
        }
    });
})();
