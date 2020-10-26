use std::ops::{Add, Mul};

#[derive(Copy, Clone, Debug)]
pub struct Point {
    pub x: f32,
    pub y: f32,
}

pub fn point(x: f32, y: f32) -> Point {
    Point { x, y }
}

impl Add<Point> for Point {
    type Output = Point;

    fn add(self, a: Point) -> Point {
        Point {
            x: self.x + a.x,
            y: self.y + a.y,
        }
    }
}

impl Mul<Point> for f32 {
    type Output = Point;
    fn mul(self, a: Point) -> Point {
        Point {
            x: self * a.x,
            y: self * a.y,
        }
    }
}

pub fn between(a: Point, b: Point, x: f32) -> Point {
    let dx = b.x - a.x;
    let dy = b.y - a.y;

    let delta_y = (x - a.x) * dy / dx;
    let y = a.y + delta_y;

    point(x, y)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn add_points() {
        let a = point(1.0, 2.0);
        let b = point(3.0, 4.0);
        let c = a + b;
        assert_eq!(c.x, 4.0);
        assert_eq!(c.y, 6.0);
    }

    #[test]
    fn mul_points() {
        let a = point(1.0, 2.0);
        let c = 3.0 * a;
        assert_eq!(c.x, 3.0);
        assert_eq!(c.y, 6.0);
    }

    #[test]
    fn test_between() {
        let a = point(1.0, 2.0);
        let b = point(4.0, 8.0);
        let c = between(a, b, 2.0);
        assert_eq!(c.x, 2.0);
        assert_eq!(c.y, 4.0);
    }
}
