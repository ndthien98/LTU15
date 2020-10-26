use crate::algorithm::show_segments;
use crate::algorithm::{segment, supremum, Segment};
use crate::point::between;
use crate::point::point;

pub struct FuzzySet {
    pub segments: Vec<Segment>,
}

pub struct Function {
    pub segments: Vec<Segment>,
}

fn compute_positions(set: &FuzzySet, func: &Function) -> Vec<f32> {
    let mut result = Vec::new();

    result.extend(set.segments.iter().map(|s| s.a.x));
    result.push(set.segments.last().unwrap().b.x);

    result.extend(func.segments.iter().map(|s| s.a.x));
    result.push(func.segments.last().unwrap().b.x);

    result.sort_by(|a, b| a.partial_cmp(b).unwrap());
    result.dedup();

    result
}

pub fn new_segments(segments: &[Segment], positions: &[f32]) -> Vec<Segment> {
    let mut result = Vec::new();
    let mut pos_index = 0;

    for s in segments.iter() {
        let ax = s.a.x;
        let bx = s.b.x;

        while let Some(x) = positions.get(pos_index) {
            if *x > ax {
                break;
            }
            pos_index += 1;
        }

        let mut prev_point = s.a;
        while let Some(x) = positions.get(pos_index) {
            if *x >= bx {
                break;
            }

            let mid = between(s.a, s.b, *x);
            result.push(segment(prev_point, mid));
            prev_point = mid;

            pos_index += 1;
        }
        result.push(segment(prev_point, s.b));
    }

    result
}

#[allow(dead_code)]
pub fn apply_before_supremum(set: &FuzzySet, func: &Function) -> FuzzySet {
    let mut result = Vec::new();
    let positions = compute_positions(set, func);

    let new_set_segments = new_segments(&set.segments, &positions);
    let new_func_segments = new_segments(&func.segments, &positions);

    // for p in positions.iter() {
    //     print!("{} ", p);
    // }
    // println!("");

    // show_segments(&new_set_segments);
    // show_segments(&new_func_segments);
    assert!(new_set_segments.len() <= new_func_segments.len());

    let it1 = new_set_segments.iter();
    let it2 = new_func_segments.iter();

    for (s1, s2) in it1.zip(it2) {
        // println!("Segment: ({}, {}) ({}, {})", s1.a.x, s1.a.y, s1.b.x, s1.b.y);
        // println!("Segment: ({}, {}) ({}, {})", s2.a.x, s2.a.y, s2.b.x, s2.b.y);
        assert_eq!(s1.a.x, s2.a.x);
        assert_eq!(s1.b.x, s2.b.x);
        let a = point(s2.a.y, s1.a.y);
        let b = point(s2.b.y, s1.b.y);
        if a.x != b.x {
            result.push(segment(a, b));
        }
    }

    FuzzySet { segments: result }
}

#[allow(dead_code)]
pub fn apply(set: &FuzzySet, func: &Function) -> FuzzySet {
    FuzzySet {
        segments: supremum(&apply_before_supremum(set, func).segments),
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_new_segments() {
        let a = point(1.0, 1.0);
        let b = point(2.0, 3.0);
        let c = point(4.0, 0.0);
        let segments = vec![segment(a, b), segment(b, c)];
        let new = new_segments(&segments, &[1.0, 1.5, 2.0, 3.0, 4.0]);
        assert_eq!(new.len(), 4);

        assert_eq!(new[0].a.x, 1.0);
        assert_eq!(new[0].b.x, 1.5);
        assert_eq!(new[0].a.y, 1.0);
        assert_eq!(new[0].b.y, 2.0);

        assert_eq!(new[1].a.x, 1.5);
        assert_eq!(new[1].b.x, 2.0);
        assert_eq!(new[1].a.y, 2.0);
        assert_eq!(new[1].b.y, 3.0);

        assert_eq!(new[2].a.x, 2.0);
        assert_eq!(new[2].b.x, 3.0);
        assert_eq!(new[2].a.y, 3.0);
        assert_eq!(new[2].b.y, 1.5);
    }
}
