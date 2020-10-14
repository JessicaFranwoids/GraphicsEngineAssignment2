#version 330

in vec3 color;
out vec4 fragColour;

void main(void) {
	fragColour = vec4(color,1.0);
}
