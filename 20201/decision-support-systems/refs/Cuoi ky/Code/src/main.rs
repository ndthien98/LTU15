mod algorithm;
mod fuzzy;
mod point;

use algorithm::{segment, show_segments, supremum, Segment};
use fuzzy::{Function, FuzzySet};
use point::point;
use std::fs::File;
use std::io::{BufRead, BufReader, Write};
use std::time::Instant;

fn input() -> Vec<Segment> {
    let mut result = Vec::new();

    let file = File::open("input").unwrap();
    let reader = BufReader::new(file);
    for line in reader.lines() {
        let line = line.unwrap();
        let numbers: Vec<f32> = line
            .split_whitespace()
            .map(|s| s.parse::<f32>().unwrap())
            .collect();
        let a = point(numbers[0], numbers[1]);
        let b = point(numbers[2], numbers[3]);
        result.push(segment(a, b));
    }

    result
}

fn write_data(filename: &str, segments: &[Segment]) {
    let mut file = File::create(filename).unwrap();
    for s in segments.iter() {
        writeln!(file, "{} {} {} {}", s.a.x, s.a.y, s.b.x, s.b.y).unwrap();
    }
}

#[allow(dead_code)]
fn run_supremum() {
    let segments = input();

    algorithm::show_segments(&segments);
    let result = supremum(&segments);
    algorithm::show_segments(&result);

    write_data("output", &result);
}

#[allow(dead_code)]
fn run_example2() {
    let mut set = {
        let a = point(0.0, 0.0);
        let b = point(0.75, 1.0);
        let c = point(1.0, 0.0);

        FuzzySet {
            segments: vec![segment(a, b), segment(b, c)],
        }
    };

    let func = {
        let a = point(0.0, 0.0);
        let b = point(0.25, 0.9);
        let c = point(1.0, 0.0);

        Function {
            segments: vec![segment(a, b), segment(b, c)],
        }
    };

    write_data("example2/data/input", &set.segments);
    write_data("example2/data/func", &func.segments);
    for _ in 0..2 {
        set = fuzzy::apply(&set, &func);
        show_segments(&set.segments);
        write_data("example2/data/output", &set.segments);
        println!("------------------------------------------");
    }
}

#[allow(dead_code)]
fn run_example2_3d() {
    let mut set = {
        let a = point(0.0, 0.0);
        let b = point(0.75, 1.0);
        let c = point(1.0, 0.0);

        FuzzySet {
            segments: vec![segment(a, b), segment(b, c)],
        }
    };

    let func = {
        let a = point(0.0, 0.0);
        let b = point(0.25, 0.9);
        let c = point(1.0, 0.0);

        Function {
            segments: vec![segment(a, b), segment(b, c)],
        }
    };

    write_data("example2/data3d/input", &set.segments);
    write_data("example2/data3d/func", &func.segments);
    for i in 0..20 {
        set = fuzzy::apply(&set, &func);
        show_segments(&set.segments);
        let path = format!("example2/data3d/output{}", i + 1);
        write_data(&path, &set.segments);
        println!("------------------------------------------");
    }
}

#[allow(dead_code)]
fn run_example3_3d() {
    let mut set = {
        let a = point(0.0, 0.0);
        let b = point(0.2, 0.0);
        let c = point(0.4, 0.6);
        let d = point(0.8, 1.0);
        let e = point(0.9, 0.0);
        let f = point(1.0, 0.0);

        FuzzySet {
            segments: vec![
                segment(a, b),
                segment(b, c),
                segment(c, d),
                segment(d, e),
                segment(e, f),
            ],
        }
    };

    let func = {
        let a = point(0.0, 0.0);
        let b = point(0.4 / 3.0, 0.75);
        let c = point(0.4, 0.6);
        let d = point(1.0, 0.0);

        Function {
            segments: vec![segment(a, b), segment(b, c), segment(c, d)],
        }
    };

    write_data("example3/data3d/input", &set.segments);
    write_data("example3/data3d/func", &func.segments);
    for i in 0..30 {
        set = fuzzy::apply(&set, &func);
        show_segments(&set.segments);
        let path = format!("example3/data3d/output{}", i + 1);
        write_data(&path, &set.segments);
        println!("------------------------------------------");
    }
}

#[allow(dead_code)]
fn run_example4_3d() {
    let mut set = {
        let a = point(0.0, 0.0);
        let b = point(0.125, 0.0);
        let c = point(0.2, 0.225);
        let d = point(1.0 / 3.0, 0.9);
        let e = point(0.4, 0.125);
        let f = point(0.4 + 0.1 * 5.0 / 6.0, 0.125);
        let g = point(0.75, 1.0);
        let h = point(0.8, 0.35);
        let i = point(0.9, 0.7);
        let k = point(1.0, 0.0);

        FuzzySet {
            segments: vec![
                segment(a, b),
                segment(b, c),
                segment(c, d),
                segment(d, e),
                segment(e, f),
                segment(f, g),
                segment(g, h),
                segment(h, i),
                segment(i, k),
            ],
        }
    };

    let func = {
        let a = point(0.0, 0.0);
        let b = point(0.8 / 3.0, 0.9);
        let c = point(1.0, 0.0);

        Function {
            segments: vec![segment(a, b), segment(b, c)],
        }
    };

    write_data("example4/data3d/input", &set.segments);
    write_data("example4/data3d/func", &func.segments);
    for i in 0..20 {
        set = fuzzy::apply(&set, &func);
        show_segments(&set.segments);
        let path = format!("example4/data3d/output{}", i + 1);
        write_data(&path, &set.segments);
        println!("------------------------------------------");
    }
}

#[allow(dead_code)]
fn run_example2_3d_complexity() {
    let mut set = {
        let a = point(0.0, 0.0);
        let b = point(0.75, 1.0);
        let c = point(1.0, 0.0);

        FuzzySet {
            segments: vec![segment(a, b), segment(b, c)],
        }
    };

    let func = {
        let a = point(0.0, 0.0);
        let b = point(0.25, 0.9);
        let c = point(1.0, 0.0);

        Function {
            segments: vec![segment(a, b), segment(b, c)],
        }
    };

    let now = Instant::now();
    for _ in 0..10000 {
        set = fuzzy::apply(&set, &func);
    }
    println!("{:.1}", now.elapsed().as_micros() as f64 / 1000.0);

    let now = Instant::now();
    for _ in 0..100000 {
        set = fuzzy::apply(&set, &func);
    }
    println!("{:.1}", now.elapsed().as_micros() as f64 / 1000.0);

    let now = Instant::now();
    for _ in 0..1000000 {
        set = fuzzy::apply(&set, &func);
    }
    println!("{:.1}", now.elapsed().as_micros() as f64 / 1000.0);
}

#[allow(dead_code)]
fn run_example3_3d_complexity() {
    let mut set = {
        let a = point(0.0, 0.0);
        let b = point(0.2, 0.0);
        let c = point(0.4, 0.6);
        let d = point(0.8, 1.0);
        let e = point(0.9, 0.0);
        let f = point(1.0, 0.0);

        FuzzySet {
            segments: vec![
                segment(a, b),
                segment(b, c),
                segment(c, d),
                segment(d, e),
                segment(e, f),
            ],
        }
    };

    let func = {
        let a = point(0.0, 0.0);
        let b = point(0.4 / 3.0, 0.75);
        let c = point(0.4, 0.6);
        let d = point(1.0, 0.0);

        Function {
            segments: vec![segment(a, b), segment(b, c), segment(c, d)],
        }
    };

    let now = Instant::now();
    for _ in 0..10000 {
        set = fuzzy::apply(&set, &func);
    }
    println!("{:.1}", now.elapsed().as_micros() as f64 / 1000.0);

    let now = Instant::now();
    for _ in 0..100000 {
        set = fuzzy::apply(&set, &func);
    }
    println!("{:.1}", now.elapsed().as_micros() as f64 / 1000.0);

    let now = Instant::now();
    for _ in 0..1000000 {
        set = fuzzy::apply(&set, &func);
    }
    println!("{:.1}", now.elapsed().as_micros() as f64 / 1000.0);
}

#[allow(dead_code)]
fn run_example4_3d_complexity() {
    let mut set = {
        let a = point(0.0, 0.0);
        let b = point(0.125, 0.0);
        let c = point(0.2, 0.225);
        let d = point(1.0 / 3.0, 0.9);
        let e = point(0.4, 0.125);
        let f = point(0.4 + 0.1 * 5.0 / 6.0, 0.125);
        let g = point(0.75, 1.0);
        let h = point(0.8, 0.35);
        let i = point(0.9, 0.7);
        let k = point(1.0, 0.0);

        FuzzySet {
            segments: vec![
                segment(a, b),
                segment(b, c),
                segment(c, d),
                segment(d, e),
                segment(e, f),
                segment(f, g),
                segment(g, h),
                segment(h, i),
                segment(i, k),
            ],
        }
    };

    let func = {
        let a = point(0.0, 0.0);
        let b = point(0.8 / 3.0, 0.9);
        let c = point(1.0, 0.0);

        Function {
            segments: vec![segment(a, b), segment(b, c)],
        }
    };

    let now = Instant::now();
    for _ in 0..10000 {
        set = fuzzy::apply(&set, &func);
    }
    println!("{:.1}", now.elapsed().as_micros() as f64 / 1000.0);

    let now = Instant::now();
    for _ in 0..100000 {
        set = fuzzy::apply(&set, &func);
    }
    println!("{:.1}", now.elapsed().as_micros() as f64 / 1000.0);

    let now = Instant::now();
    for _ in 0..1000000 {
        set = fuzzy::apply(&set, &func);
    }
    println!("{:.1}", now.elapsed().as_micros() as f64 / 1000.0);
}

fn main() {
    run_example2();
    run_example2_3d();
    run_example3_3d();
    run_example4_3d();

    // run_example2_3d_complexity();
    // run_example3_3d_complexity();
    // run_example4_3d_complexity();
}
