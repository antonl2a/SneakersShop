const uploadImageButton = document.getElementById('uploadImgButton');
const uploadImageInput = document.getElementById('issueImg');
const imagePreview = document.getElementById('uploadImagePreview');
uploadImageButton.addEventListener('click', e => {
    console.log(e)
    e.preventDefault();
    uploadImageInput.click();
});
uploadImageInput.addEventListener('change', e => {
    const uploadedImage = uploadImageInput.files[0];
    imagePreview.src = URL.createObjectURL(uploadedImage);
    imagePreview.style.display = 'block';
})