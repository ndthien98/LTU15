use crate::point::{between, Point};

#[derive(Copy, Clone)]
pub struct Segment {
    pub a: Point,
    pub b: Point,
}

pub fn segment(a: Point, b: Point) -> Segment {
    assert!(a.x != b.x);
    if a.x < b.x {
        Segment { a: a, b: b }
    } else {
        Segment { a: b, b: a }
    }
}

fn sort_points(points: &mut [Point]) {
    points.sort_by(|u, v| u.x.partial_cmp(&v.x).unwrap());
}

#[derive(Copy, Clone)]
struct CutSection {
    u: f32,
    v: f32,
}

struct CutOutput {
    left: Option<Segment>,
    mid: Segment,
    right: Option<Segment>,
}

fn cut(s: Segment, section: CutSection) -> CutOutput {
    let m1 = between(s.a, s.b, section.u);
    let m2 = between(s.a, s.b, section.v);

    CutOutput {
        left: if s.a.x != section.u {
            Some(segment(s.a, m1))
        } else {
            None
        },
        mid: segment(m1, m2),
        right: if s.b.x != section.v {
            Some(segment(m2, s.b))
        } else {
            None
        },
    }
}

fn special_intersect(sa: Segment, sb: Segment) -> Point {
    let ax = sa.a.x;
    let bx = sa.b.x;

    let ha = sb.a.y - sa.a.y;
    let hb = sa.b.y - sb.b.y;

    let x = (bx * ha + ax * hb) / (ha + hb);
    between(sa.a, sa.b, x)
}

#[allow(dead_code)]
pub fn intersect(sa: Segment, sb: Segment, output: &mut Vec<Segment>) {
    let mut points = [sa.a, sa.b, sb.a, sb.b];
    sort_points(&mut points);
    let cut_section = CutSection {
        u: points[1].x,
        v: points[2].x,
    };

    let sa_cut_output = cut(sa, cut_section);
    let sb_cut_output = cut(sb, cut_section);

    let mut tmp_output = Vec::new();

    let first = match sa_cut_output.left {
        None => match sb_cut_output.left {
            None => None,
            Some(left2) => Some(left2),
        },
        Some(left1) => match sb_cut_output.left {
            None => Some(left1),
            Some(left2) => {
                if left1.b.y > left2.b.y {
                    Some(left1)
                } else {
                    Some(left2)
                }
            }
        },
    };

    let last = match sa_cut_output.right {
        None => match sb_cut_output.right {
            None => None,
            Some(right2) => Some(right2),
        },
        Some(right1) => match sb_cut_output.right {
            None => Some(right1),
            Some(right2) => {
                if right1.a.y > right2.a.y {
                    Some(right1)
                } else {
                    Some(right2)
                }
            }
        },
    };

    if let Some(s) = first {
        tmp_output.push(s);
    }

    let intersect_point = special_intersect(sa_cut_output.mid, sb_cut_output.mid);
    if intersect_point.x > cut_section.u && intersect_point.x < cut_section.v {
        if sa_cut_output.mid.a.y > sb_cut_output.mid.a.y {
            tmp_output.push(segment(sa_cut_output.mid.a, intersect_point));
        } else {
            tmp_output.push(segment(sb_cut_output.mid.a, intersect_point));
        }

        if sa_cut_output.mid.b.y > sb_cut_output.mid.b.y {
            tmp_output.push(segment(intersect_point, sa_cut_output.mid.b));
        } else {
            tmp_output.push(segment(intersect_point, sb_cut_output.mid.b));
        }
    } else {
        if sa_cut_output.mid.a.y > sb_cut_output.mid.a.y {
            tmp_output.push(sa_cut_output.mid);
        } else {
            tmp_output.push(sb_cut_output.mid);
        }
    }

    if let Some(s) = last {
        tmp_output.push(s);
    }

    // Merge Segments that are closed and parallel
    let mut prev_segment: Option<Segment> = None;
    let epsilon: f32 = 0.00001;
    for s in tmp_output.iter() {
        if let Some(prev) = prev_segment {
            if prev.b.x == s.a.x && prev.b.y == s.a.y {
                let m = between(prev.a, s.b, s.a.x);
                if f32::abs(m.y - s.a.y) < epsilon {
                    let new_s = segment(prev.a, s.b);
                    output.pop();
                    output.push(new_s);
                    prev_segment = Some(new_s);
                    continue;
                }
            }
        }

        output.push(*s);
        prev_segment = Some(*s);
    }

    // show_segments(&output);
}

#[allow(dead_code)]
pub fn show_segments(segments: &Vec<Segment>) {
    println!("===========================");
    for s in segments.iter() {
        println!("({}, {}) ({}, {})", s.a.x, s.a.y, s.b.x, s.b.y);
    }
}

fn can_intersect(sa: Segment, sb: Segment) -> bool {
    if sa.b.x <= sb.a.x || sa.a.x >= sb.b.x {
        false
    } else {
        true
    }
}

fn sort_segments(segments: &mut [Segment]) {
    segments.sort_by(|u, v| u.a.x.partial_cmp(&v.a.x).unwrap());
}

#[allow(dead_code)]
pub fn supremum(segments: &[Segment]) -> Vec<Segment> {
    let mut segments = Vec::from(segments);

    sort_segments(&mut segments);
    'outer: loop {
        let len = segments.len();
        for i in 0..(len - 1) {
            let sa = segments[i];
            let sb = segments[i + 1];

            if can_intersect(sa, sb) {
                segments.swap_remove(i + 1);
                segments.swap_remove(i);

                intersect(sa, sb, &mut segments);
                sort_segments(&mut segments);

                continue 'outer;
            }
        }

        return segments;
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::point::point;

    #[test]
    fn test_sort_points() {
        let mut points = [point(2.0, 1.0), point(5.0, 4.0), point(1.0, 6.0)];
        sort_points(&mut points);
        assert_eq!(points[0].x, 1.0);
        assert_eq!(points[1].x, 2.0);
        assert_eq!(points[2].x, 5.0);

        assert_eq!(points[0].y, 6.0);
        assert_eq!(points[1].y, 1.0);
        assert_eq!(points[2].y, 4.0);
    }

    #[test]
    fn test_special_intersect() {
        let a1 = point(0.0, 0.0);
        let a2 = point(0.0, 3.0);
        let b1 = point(3.0, 0.0);
        let b2 = point(3.0, 6.0);

        let m = special_intersect(segment(a1, b2), segment(a2, b1));
        assert_eq!(m.x, 1.0);
        assert_eq!(m.y, 2.0);

        let m = special_intersect(segment(a2, b1), segment(a1, b2));
        assert_eq!(m.x, 1.0);
        assert_eq!(m.y, 2.0);

        let m = special_intersect(segment(a1, b1), segment(a2, b2));
        assert_eq!(m.x, -3.0);
        assert_eq!(m.y, 0.0);
    }
}
