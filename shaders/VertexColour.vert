#version 330

layout(location=0) in vec3 pos;
layout(location=1) in vec3 colour;
layout(location=2) in vec2 texCoord;

out vec3 color;
out vec2 fragTex;

void main() {
gl_Position = vec4(pos, 1.0);
color = colour;
fragTex = texCoord;
}