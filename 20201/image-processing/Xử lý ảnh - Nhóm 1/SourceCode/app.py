import PIL.ImageTk
import PIL.Image
import tkinter as tk
import tkinter.font as tkFont
import process as process
from tkinter import filedialog
from tkinter import messagebox
import threading
from image_preview import ImagePreview
import numpy as np
import matplotlib.pyplot as plt
from matplotlib.pyplot import figure
import cv2 as cv2
import sys


class App:
    # self.width = tk.StringVar()
    # self.height = tk.StringVar()
    # self.filename = tk.StringVar()

    # self.x = tk.StringVar()
    # self.y = tk.StringVar()
    # self.a = tk.StringVar()
    # self.b = tk.StringVar()

    def __init__(self, root):
        self.width = tk.StringVar()
        self.height = tk.StringVar()
        self.filename = tk.StringVar()

        self.x = tk.StringVar()
        self.y = tk.StringVar()
        self.a = tk.StringVar()
        self.b = tk.StringVar()

        self.root = root
        root.title("Xử lí ảnh 20201 - LTU15 - Nhóm 01 ")
        width = 593
        height = 743
        screenwidth = root.winfo_screenwidth()
        screenheight = root.winfo_screenheight()
        alignstr = '%dx%d+%d+%d' % (width, height,
                                    (screenwidth - width) / 2, (screenheight - height) / 2)
        root.geometry(alignstr)
        root.resizable(width=False, height=False)

        GLabel_194 = tk.Label(root)
        ft = tkFont.Font(family='Courier', size=12)
        GLabel_194["font"] = ft
        GLabel_194["fg"] = "#333333"
        GLabel_194["justify"] = "left"
        GLabel_194["text"] = "1. Thay đổi định dạng"
        GLabel_194.place(x=10, y=70, width=180, height=30)

        btn_open_file = tk.Button(root)
        btn_open_file["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_open_file["font"] = ft
        btn_open_file["fg"] = "#000000"
        btn_open_file["justify"] = "center"
        btn_open_file["text"] = "Mở file"
        btn_open_file.place(x=30, y=30, width=70, height=25)
        btn_open_file["command"] = self.btn_open_file_command

        btn_save_png = tk.Button(root)
        btn_save_png["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_save_png["font"] = ft
        btn_save_png["fg"] = "#000000"
        btn_save_png["justify"] = "center"
        btn_save_png["text"] = "Lưu PNG"
        btn_save_png.place(x=30, y=110, width=70, height=25)
        btn_save_png["command"] = self.btn_save_png_command

        btn_save_jpeg = tk.Button(root)
        btn_save_jpeg["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_save_jpeg["font"] = ft
        btn_save_jpeg["fg"] = "#000000"
        btn_save_jpeg["justify"] = "center"
        btn_save_jpeg["text"] = "Lưu JPEG"
        btn_save_jpeg.place(x=120, y=110, width=70, height=25)
        btn_save_jpeg["command"] = self.btn_save_jpeg_command

        btn_save_tiff = tk.Button(root)
        btn_save_tiff["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_save_tiff["font"] = ft
        btn_save_tiff["fg"] = "#000000"
        btn_save_tiff["justify"] = "center"
        btn_save_tiff["text"] = "Lưu TIFF"
        btn_save_tiff.place(x=210, y=110, width=70, height=25)
        btn_save_tiff["command"] = self.btn_save_tiff_command

        btn_save_pfm = tk.Button(root)
        btn_save_pfm["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_save_pfm["font"] = ft
        btn_save_pfm["fg"] = "#000000"
        btn_save_pfm["justify"] = "center"
        btn_save_pfm["text"] = "Lưu PFM"
        btn_save_pfm.place(x=300, y=110, width=70, height=25)
        btn_save_pfm["command"] = self.btn_save_pfm_command

        btn_save_hdr = tk.Button(root)
        btn_save_hdr["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_save_hdr["font"] = ft
        btn_save_hdr["fg"] = "#000000"
        btn_save_hdr["justify"] = "center"
        btn_save_hdr["text"] = "Lưu HDR"
        btn_save_hdr.place(x=390, y=110, width=70, height=25)
        btn_save_hdr["command"] = self.btn_save_hdr_command

        GLabel_980 = tk.Label(root)
        ft = tkFont.Font(family='Courier', size=12)
        GLabel_980["font"] = ft
        GLabel_980["fg"] = "#333333"
        GLabel_980["justify"] = "center"
        GLabel_980["text"] = "Width"
        GLabel_980.place(x=40, y=160, width=70, height=25)

        GLabel_436 = tk.Label(root)
        ft = tkFont.Font(family='Courier', size=12)
        GLabel_436["font"] = ft
        GLabel_436["fg"] = "#333333"
        GLabel_436["justify"] = "center"
        GLabel_436["text"] = "Heigh"
        GLabel_436.place(x=40, y=200, width=70, height=25)

        edit_width = tk.Entry(root, textvariable=self.width)
        self.edit_width = edit_width
        edit_width["borderwidth"] = "1px"
        ft = tkFont.Font(family='Courier', size=12)
        edit_width["font"] = ft
        edit_width["fg"] = "#333333"
        edit_width["justify"] = "right"
        edit_width.place(x=110, y=160, width=170, height=25)

        edit_height = tk.Entry(root, textvariable=self.height)
        self.edit_height = edit_height
        edit_height["borderwidth"] = "1px"
        ft = tkFont.Font(family='Courier', size=12)
        edit_height["font"] = ft
        edit_height["fg"] = "#333333"
        edit_height["justify"] = "right"
        edit_height.place(x=110, y=200, width=170, height=25)

        btn_reset_size = tk.Button(root)
        btn_reset_size["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_reset_size["font"] = ft
        btn_reset_size["fg"] = "#000000"
        btn_reset_size["justify"] = "center"
        btn_reset_size["text"] = "Đặt lại"
        btn_reset_size.place(x=310, y=180, width=70, height=25)
        btn_reset_size["command"] = self.btn_reset_size_command

        btn_preview = tk.Button(root)
        btn_preview["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_preview["font"] = ft
        btn_preview["fg"] = "#000000"
        btn_preview["justify"] = "center"
        btn_preview["text"] = "Xử lý"
        btn_preview.place(x=400, y=180, width=70, height=25)
        btn_preview["command"] = self.btn_resize_command

        GLabel_576 = tk.Label(root)
        ft = tkFont.Font(family='Courier', size=12)
        GLabel_576["font"] = ft
        GLabel_576["fg"] = "#333333"
        GLabel_576["justify"] = "left"
        GLabel_576["text"] = "2. Thay đổi hệ màu"
        GLabel_576.place(x=10, y=250, width=141, height=25)

        btn_color_rgb = tk.Button(root)
        btn_color_rgb["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_color_rgb["font"] = ft
        btn_color_rgb["fg"] = "#000000"
        btn_color_rgb["justify"] = "center"
        btn_color_rgb["text"] = "RGB"
        btn_color_rgb.place(x=40, y=290, width=70, height=25)
        btn_color_rgb["command"] = self.btn_color_rgb_command

        btn_color_cmyk = tk.Button(root)
        btn_color_cmyk["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_color_cmyk["font"] = ft
        btn_color_cmyk["fg"] = "#000000"
        btn_color_cmyk["justify"] = "center"
        btn_color_cmyk["text"] = "CMYK"
        btn_color_cmyk.place(x=130, y=290, width=70, height=25)
        btn_color_cmyk["command"] = self.btn_color_cmyk_command

        btn_color_hsv = tk.Button(root)
        btn_color_hsv["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_color_hsv["font"] = ft
        btn_color_hsv["fg"] = "#000000"
        btn_color_hsv["justify"] = "center"
        btn_color_hsv["text"] = "HSV"
        btn_color_hsv.place(x=220, y=290, width=70, height=25)
        btn_color_hsv["command"] = self.btn_color_hsv_command

        btn_color_gray = tk.Button(root)
        btn_color_gray["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_color_gray["font"] = ft
        btn_color_gray["fg"] = "#000000"
        btn_color_gray["justify"] = "center"
        btn_color_gray["text"] = "Gray scale"
        btn_color_gray.place(x=310, y=290, width=70, height=25)
        btn_color_gray["command"] = self.btn_color_gray_command

        GLabel_988 = tk.Label(root)
        ft = tkFont.Font(family='Courier', size=12)
        GLabel_988["font"] = ft
        GLabel_988["fg"] = "#333333"
        GLabel_988["justify"] = "left"
        GLabel_988["text"] = "3. Tăng cường độ tương phản"
        GLabel_988.place(x=10, y=330, width=200, height=30)

        btn_preview_open_image = tk.Button(root)
        btn_preview_open_image["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_preview_open_image["font"] = ft
        btn_preview_open_image["fg"] = "#000000"
        btn_preview_open_image["justify"] = "center"
        btn_preview_open_image["text"] = "Xem ảnh"
        btn_preview_open_image.place(x=120, y=30, width=70, height=25)
        btn_preview_open_image["command"] = self.btn_preview_open_image_command

        btn_exit = tk.Button(root)
        btn_exit["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_exit["font"] = ft
        btn_exit["fg"] = "#000000"
        btn_exit["justify"] = "center"
        btn_exit["text"] = "Thoát"
        btn_exit.place(x=210, y=30, width=70, height=25)
        btn_exit["command"] = self.btn_exit_command

        lb_opened_file = tk.Label(root)
        ft = tkFont.Font(family='Courier', size=12)
        lb_opened_file["font"] = ft
        lb_opened_file["fg"] = "#333333"
        lb_opened_file["justify"] = "left"
        lb_opened_file["text"] = "File: "
        lb_opened_file.place(x=300, y=30, width=250, height=25)
        self.lb_opened_file = lb_opened_file

        edit_a = tk.Entry(root, textvariable=self.a)
        edit_a["borderwidth"] = "1px"
        ft = tkFont.Font(family='Courier', size=12)
        edit_a["font"] = ft
        edit_a["fg"] = "#333333"
        edit_a["justify"] = "center"
        edit_a.place(x=100, y=360, width=70, height=25)

        GLabel_269 = tk.Label(root)
        ft = tkFont.Font(family='Courier', size=12)
        GLabel_269["font"] = ft
        GLabel_269["fg"] = "#333333"
        GLabel_269["justify"] = "center"
        GLabel_269["text"] = "Hệ số a"
        GLabel_269.place(x=20, y=360, width=70, height=25)

        GLabel_568 = tk.Label(root)
        ft = tkFont.Font(family='Courier', size=12)
        GLabel_568["font"] = ft
        GLabel_568["fg"] = "#333333"
        GLabel_568["justify"] = "center"
        GLabel_568["text"] = "Hệ số b"
        GLabel_568.place(x=20, y=390, width=70, height=25)

        edit_b = tk.Entry(root, textvariable=self.b)
        edit_b["borderwidth"] = "1px"
        ft = tkFont.Font(family='Courier', size=12)
        edit_b["font"] = ft
        edit_b["fg"] = "#333333"
        edit_b["justify"] = "center"
        edit_b.place(x=100, y=390, width=70, height=25)

        btn_process_contrast = tk.Button(root)
        btn_process_contrast["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_process_contrast["font"] = ft
        btn_process_contrast["fg"] = "#000000"
        btn_process_contrast["justify"] = "center"
        btn_process_contrast["text"] = "Xử lí"
        btn_process_contrast.place(x=190, y=360, width=70, height=25)
        btn_process_contrast["command"] = self.btn_process_contrast_command

        GLabel_584 = tk.Label(root)
        ft = tkFont.Font(family='Courier', size=12)
        GLabel_584["font"] = ft
        GLabel_584["fg"] = "#333333"
        GLabel_584["justify"] = "left"
        GLabel_584["text"] = "4. Biên tập ảnh"
        GLabel_584.place(x=10, y=430, width=165, height=30)

        btn_pick_logo = tk.Button(root)
        btn_pick_logo["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_pick_logo["font"] = ft
        btn_pick_logo["fg"] = "#000000"
        btn_pick_logo["justify"] = "center"
        btn_pick_logo["text"] = "Chọn logo"
        btn_pick_logo.place(x=40, y=470, width=70, height=25)
        btn_pick_logo["command"] = self.btn_pick_logo_command

        btn_insert_logo = tk.Button(root)
        btn_insert_logo["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_insert_logo["font"] = ft
        btn_insert_logo["fg"] = "#000000"
        btn_insert_logo["justify"] = "center"
        btn_insert_logo["text"] = "Chèn"
        btn_insert_logo.place(x=130, y=470, width=70, height=25)
        btn_insert_logo["command"] = self.btn_insert_logo_command

        btn_save_resized_image = tk.Button(root)
        btn_save_resized_image["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_save_resized_image["font"] = ft
        btn_save_resized_image["fg"] = "#000000"
        btn_save_resized_image["justify"] = "center"
        btn_save_resized_image["text"] = "Lưu ảnh"
        btn_save_resized_image.place(x=490, y=180, width=70, height=25)
        btn_save_resized_image["command"] = self.btn_save_resized_image_command

        btn_save_inserted_logo = tk.Button(root)
        btn_save_inserted_logo["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_save_inserted_logo["font"] = ft
        btn_save_inserted_logo["fg"] = "#000000"
        btn_save_inserted_logo["justify"] = "center"
        btn_save_inserted_logo["text"] = "Lưu ảnh"
        btn_save_inserted_logo.place(x=220, y=470, width=70, height=25)
        btn_save_inserted_logo["command"] = self.btn_save_inserted_logo_command

        edit_x_offset = tk.Entry(root, textvariable=self.x)
        edit_x_offset["borderwidth"] = "1px"
        ft = tkFont.Font(family='Courier', size=12)
        edit_x_offset["font"] = ft
        edit_x_offset["fg"] = "#333333"
        edit_x_offset["justify"] = "center"
        edit_x_offset.place(x=110, y=510, width=70, height=25)

        GLabel_88 = tk.Label(root)
        ft = tkFont.Font(family='Courier', size=12)
        GLabel_88["font"] = ft
        GLabel_88["fg"] = "#333333"
        GLabel_88["justify"] = "center"
        GLabel_88["text"] = "Toạ độ X"
        GLabel_88.place(x=40, y=510, width=70, height=25)

        GLabel_82 = tk.Label(root)
        ft = tkFont.Font(family='Courier', size=12)
        GLabel_82["font"] = ft
        GLabel_82["fg"] = "#333333"
        GLabel_82["justify"] = "center"
        GLabel_82["text"] = "Toạ độ Y"
        GLabel_82.place(x=180, y=510, width=70, height=25)

        edit_y_offset = tk.Entry(root, textvariable=self.y)
        edit_y_offset["borderwidth"] = "1px"
        ft = tkFont.Font(family='Courier', size=12)
        edit_y_offset["font"] = ft
        edit_y_offset["fg"] = "#333333"
        edit_y_offset["justify"] = "center"
        edit_y_offset.place(x=250, y=510, width=70, height=25)

        btn_save_contrast_image = tk.Button(root)
        btn_save_contrast_image["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_save_contrast_image["font"] = ft
        btn_save_contrast_image["fg"] = "#000000"
        btn_save_contrast_image["justify"] = "center"
        btn_save_contrast_image["text"] = "Lưu ảnh"
        btn_save_contrast_image.place(x=190, y=390, width=70, height=25)
        btn_save_contrast_image["command"] = self.btn_save_contrast_image_command

        btn_delete_background = tk.Button(root)
        btn_delete_background["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_delete_background["font"] = ft
        btn_delete_background["fg"] = "#000000"
        btn_delete_background["justify"] = "center"
        btn_delete_background["text"] = "Xoá nền"
        btn_delete_background.place(x=260, y=580, width=80, height=30)
        btn_delete_background["command"] = self.btn_delete_background_command

        btn_save_deleted_background_image = tk.Button(root)
        btn_save_deleted_background_image["bg"] = "#efefef"
        ft = tkFont.Font(family='Courier', size=12)
        btn_save_deleted_background_image["font"] = ft
        btn_save_deleted_background_image["fg"] = "#000000"
        btn_save_deleted_background_image["justify"] = "center"
        btn_save_deleted_background_image["text"] = "Lưu ảnh"
        btn_save_deleted_background_image.place(
            x=350, y=580, width=82, height=30)
        btn_save_deleted_background_image["command"] = self.btn_save_deleted_background_image_command
# 1.

    def btn_open_file_command(self):
        filename = self.openfile()
        self.filename = filename
        self.img = cv2.imread(filename)
        self.width.set(self.img.shape[0])
        self.height.set(self.img.shape[1])
        print("command1")

    def btn_save_png_command(self):
        """
        Hàm lưu ảnh dưới định dạng PNG
        """
        cv2.imwrite("output.png", self.img)
        messagebox.showinfo(title="Lưu file PNG", message="Thành công!")
        print("command2")

    def btn_save_jpeg_command(self):
        """
        Hàm lưu ảnh dưới định dạng JPEG
        """
        cv2.imwrite("output.jpeg", self.img)
        messagebox.showinfo(title="Lưu file JPEG", message="Thành công!")
        print("command3")

    def btn_save_tiff_command(self):
        """
        Hàm lưu ảnh dưới định dạng TIFF
        """
        cv2.imwrite("output.tiff", self.img)
        messagebox.showinfo(title="Lưu file TIFF", message="Thành công!")
        print("command4")

    def btn_save_pfm_command(self):
        """
        Hàm lưu ảnh dưới định dạng PFM
        """
        cv2.imwrite("output.pfm", self.img)
        messagebox.showinfo(title="Lưu file PFM", message="Thành công!")
        print("command5")

    def btn_save_hdr_command(self):
        """
        Hàm lưu ảnh dưới định dạng HDR
        """
        cv2.imwrite("output.hdr", self.img)
        messagebox.showinfo(title="Lưu file HDR", message="Thành công!")
        print("command6")

    def btn_reset_size_command(self):
        """
        Hàm thực hiện reset lại thông số kích thước của ảnh ban đầu
        """
        self.width.set(self.img.shape[0])
        self.height.set(self.img.shape[1])
        print("command7")

    def btn_save_resized_image_command(self):
        """
        Hàm thực hiện lưu file đã thay đổi kích thước ảnh. 
        """
        print("command18")
        cv2.imwrite("resized_output.png", self.img_process)
        messagebox.showinfo(
            title="Đã lưu file thay đổi kích thước", message="Thành công!")

    def btn_resize_command(self):
        """
        Hàm thay đổi kích thước của ảnh
        """
        width_scale = int(self.width.get())
        height_scale = int(self.height.get())

        dim = (width_scale, height_scale)
        self.img_process = cv2.resize(
            self.img, dim, interpolation=cv2.INTER_AREA)
        self.app = ImagePreview(self.img_process)
        print("command8")
# 2.

    def btn_color_rgb_command(self):
        """
        Hàm hiển thị ảnh RGB
        """
        print("command9")
        self.app = ImagePreview(self.img)

    def btn_color_cmyk_command(self):
        print("command10")

    def btn_color_hsv_command(self):
        """
        Hàm chuyển  đổi hệ màu RGB thành HSV
        """
        print("command11")
        img_hsv = cv2.cvtColor(self.img, cv2.COLOR_BGR2HSV)
        self.app = ImagePreview(img_hsv)

    def btn_color_gray_command(self):
        """
        Hàm chuyển  đổi hệ màu RGB thành Gray scale (đa mức xám)
        """
        print("command12")
        img_gray = cv2.cvtColor(self.img, cv2.COLOR_BGR2GRAY)
        self.app = ImagePreview(img_gray)

    def btn_preview_open_image_command(self):
        self.app = ImagePreview(self.img)
        print("command13")
# 3.

    def btn_process_contrast_command(self):
        self.img_contrast = self.filter_f1(self.img, float(self.a.get()), int(self.b.get()))
        self.app = ImagePreview(self.img_contrast)
        print("command15")

    def btn_save_contrast_image_command(self):
        """
        Hàm lưu ảnh đã được chỉnh sửa độ tương phản
        """
        cv2.imwrite("contrast_output.png", self.img_process)
        print("command20")

    def filter_f1(self, img, alpha=1, a=0):
        w, h, c = img.shape
        ret = np.zeros(img.shape, dtype=np.uint8)
        for k in range(c):
            for i in range(w):
                for j in range(h):
                    if 0 <= img[i][j][k] and img[i][j][k] < a:
                        ret[i][j][k] = 0
                    else:
                        ret[i][j][k] = img[i][j][k] * alpha
        return ret

# 4.

    def btn_pick_logo_command(self):
        ftypes = [('JPG files', '*.jpg'),
                  ('PNG files', '*.png'), ('All files', '*')]
        filename = filedialog.askopenfilename(
            parent=self.root, filetypes=ftypes)
        self.logo = cv2.imread(filename)
        self.x.set("0")
        self.y.set("0")
        print("command16")

    def btn_insert_logo_command(self):
        # Thêm 1 ảnh vào 1 ảnh
        self.img_insert = self.img

        x_offset = int(self.x.get())
        y_offset = int(self.y.get())

        width, height, _ = self.logo.shape

        self.img_insert[y_offset:y_offset+width,
                        x_offset:x_offset+height] = self.logo
        self.app = ImagePreview(self.img_insert)
        print("command17")

    def btn_save_inserted_logo_command(self):
        cv2.imwrite("inserted_output.png", self.img_insert)
        messagebox.showinfo(
            title="Đã lưu file insert!", message="Thành công!")

        print("command19")

# 5.
    def btn_pick_background_command(self):
        filename = self.openfile()
        self.img_bg = cv2.imread(filename)
        print("command21")

    def btn_pick_main_image_command(self):
        filename = self.openfile()
        self.img_main = cv2.imread(filename, 3)
        print("command22")

    def btn_delete_background_command(self):

        mask = np.zeros(self.img.shape[:2], np.uint8)
        bgdModel = np.zeros((1, 65), np.float64)
        fgdModel = np.zeros((1, 65), np.float64)
        rect = (50, 50, 450, 290)
        cv2.grabCut(self.img, mask, rect, bgdModel,
                    fgdModel, 5, cv2.GC_INIT_WITH_RECT)
        mask2 = np.where((mask == 2) | (mask == 0), 0, 1).astype('uint8')
        self.img_bg = self.img*mask2[:, :, np.newaxis]
        self.app = ImagePreview(self.img_bg)
        print("command23")

    def btn_save_deleted_background_image_command(self):
        cv2.imwrite("deletebg.jpg", self.img)
        print("command24")

    def openfile(self):
        ftypes = [('JPG files', '*.jpg'),
                  ('PNG files', '*.png'), ('All files', '*')]
        filename = filedialog.askopenfilename(
            parent=self.root, filetypes=ftypes)
        self.lb_opened_file.configure(text="Opened: "+filename.split('/')[-1])
        return filename

    def savefile(self, filetypes):
        file = filedialog.asksaveasfile(
            filetypes=[filetypes], defaultextension=[filetypes])
        file.close()

    def showImg(self):
        canvas = tk.Canvas(self.root, width=self.img.shape.width,
                           height=self.img.shape.height)
        canvas.pack()
        photo = PIL.ImageTk.PhotoImage(image=PIL.Image.fromarray(cv_img))
        canvas.create_image(0, 0, image=photo, anchor=tk.NW)

    def btn_exit_command(self):
        """
        Hàm thực hiện thoát chương trình
        """
        sys.exit()
        print("command14")


if __name__ == "__main__":
    root = tk.Tk()
    app = App(root)
    root.mainloop()
