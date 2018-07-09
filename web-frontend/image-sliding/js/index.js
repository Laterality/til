var container = document.getElementById("img-container");
var currentImg = 0;
var start = null;

var slideLeft = (timestamp) => {
	if (!start) { start = timestamp; }

	// progresss = elapsed / duration
	var progress = (timestamp - start) / 750;
	container.style.left = (currentImg + 1) * -100 * progress + "%";
	console.log(progress);

	if (progress > 1) {
		start = null;
		container.style.left = (currentImg + 1) * -100 + "%";
		currentImg++;
	}
	else {
		window.requestAnimationFrame(slideLeft);
	}
}

var slideRight = (timestamp) => {
	if (!start) { start = timestamp; }

	// progresss = elapsed / duration
	var progress = (timestamp - start) / 750;
	container.style.left = currentImg * -100 * (1 - progress) + "%";
	console.log(progress);

	if (progress > 1) {
		start = null;
		container.style.left = (currentImg - 1) * -100 + "%";
		currentImg--;
	}
	else {
		window.requestAnimationFrame(slideRight);
	}
}

window.requestAnimationFrame(slideLeft);
setTimeout(() => {
	window.requestAnimationFrame(slideRight);
}, 1000);