var danchim = [1, 4, 2, 3, 1, 0, 5, 1, 2, 3, 0, 1, 4, 6, 7, 8, 0, 3, 3, 1, 3, 5, 0, 6, 8, 9, 1, 1, 2, 3, 9, 1, 2, 5, 4, 7, 6, 9, 8, 0, 9, 6, 7, 8, 6, 3, 4]

var dem = []

danchim.forEach((loaichim) => {
  dem[loaichim] = dem[loaichim] ? dem[loaichim] + 1 : 1
})

longchim = []
dem.forEach((soluongchim, loaichim) => {
  for (let i = 0; i < soluongchim; i++) {
    longchim.push(loaichim)
  }
})

console.log(longchim);
