.PHONY: all test format

all:
	cargo run --release

test:
	cargo test

format:
	cd example4 && python draw3d.py

count:
	git ls-files "*.rs" | xargs wc -l
