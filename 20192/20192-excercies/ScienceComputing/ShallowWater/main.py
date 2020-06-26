from numpy import *
import matplotlib.pyplot as plt
import time
import scipy.io as sio
def write_H_to_file(h,x):
    output = open("./output-sample3/mesh"+str(x),"w+")
    for i in h:
        for j in i:
            output.write(str(j))
            output.write(" ")
    output.close()

def d_dx(f,dx):
    """
    Input: 2-d matrix representation of f(x,y).
    Output: derivate of f follow by dx using balance finite differences.
    df[i,j] = ( f[i+1,j] - f[i-1,j] ) / (2*dx)
    """

    ans = (roll(f, -1, axis=1) - roll(f, 1, axis=1)) / (2.0*dx)

    return ans
def d_dy(f,dy):
    """
    Input: 2-d matrix representation of f(x,y).
    Output: derivate of f follow by dy using balance finite differences.
    df[i,j] = ( f[i,j+1] - f[i,j-1] ) / (2*dx)
    """

    ans = (roll(f, -1, axis=0) - roll(f, 1, axis=0)) / (2.0*dy)
    
    return ans

# Initial Conditions

g = 9.8 # acceleration due to gravity 
f = 0.0001 #  Coriolis coefficient 

box_size = 1
n = 100 # nx ny
dx = box_size/n
dy = box_size/n

u = zeros((n,n)) # velocity in x direction
v = zeros((n,n)) # velocity in y direction

# initialize H with a dick 
h = ones((n,n))*2  # pressure deviation (like height)
x,y = mgrid[:n,:n]
droplet_x, droplet_y = 70, 70
rr = (x-droplet_x)**2 + (y-droplet_y)**2
h[rr<10**2] = 2.5 # add a perturbation in pressure surface



# my fucking init condition

# data = sio.loadmat("input.mat")
# h = data['h']
# h = 1500*h
# end of it



dt = 1.0 / box_size / n / 100

count = 0
while True:
    write_H_to_file(h,count)

    count = count + 1
    if count > 3000: break

    du_dt = -g*d_dx(h,dx) + f*v
    dv_dt = -g*d_dy(h,dy) - f*u
    dh_dt = -d_dx(u * h,dx) - d_dy(v * h,dy)

    h = h + dh_dt * dt
    u = u + du_dt * dt
    v = v + dv_dt * dt
    plt.imshow(h)
    
    
plt.show()
print(str(n) + " x " + str(n) + " x " + str(count))




