class Controller:
    def __init__(self, app):
        print("Created controller")
        self.app = app

    def btn_open_file_command(self):
        filename = self.openfile()
        self.filename = filename
        self.img = cv2.imread(filename)
        self.width.set(self.img.shape[0])
        self.height.set(self.img.shape[1])
        print("command1")

    def btn_save_png_command(self):
        cv2.imwrite("output.png", self.img)
        messagebox.showinfo(title="Lưu file PNG", message="Thành công!")
        print("command2")

    def btn_save_jpeg_command(self):
        cv2.imwrite("output.jpeg", self.img)
        messagebox.showinfo(title="Lưu file JPEG", message="Thành công!")
        print("command3")

    def btn_save_tiff_command(self):
        cv2.imwrite("output.tiff", self.img)
        messagebox.showinfo(title="Lưu file TIFF", message="Thành công!")
        print("command4")

    def btn_save_pfm_command(self):
        cv2.imwrite("output.pfm", self.img)
        messagebox.showinfo(title="Lưu file PFM", message="Thành công!")
        print("command5")

    def btn_save_hdr_command(self):
        cv2.imwrite("output.hdr", self.img)
        messagebox.showinfo(title="Lưu file HDR", message="Thành công!")
        print("command6")

    def btn_reset_size_command(self):
        self.width.set(self.img.shape[0])
        self.height.set(self.img.shape[1])
        print("command7")

    def btn_preview_command(self):
        self.app = ImagePreview(self.img)
        print("command8")

    def btn_color_rgb_command(self):
        print("command9")

    def btn_color_cmyk_command(self):
        print("command10")

    def btn_color_hsv_command(self):
        print("command11")

    def btn_color_hsl_command(self):
        print("command12")

    def btn_preview_open_image_command(self):
        print("command13")

    def btn_exit_command(self):
        print("command14")

    def btn_process_contrast_command(self):
        print("command15")

    def btn_pick_logo_command(self):
        print("command16")

    def btn_insert_logo_command(self):
        print("command17")

    def btn_save_image_command(self):
        print("command18")

    def btn_save_inserted_logo_command(self):
        print("command19")

    def btn_save_inserted_image_command(self):
        print("command20")

    def btn_pick_background_command(self):
        print("command21")

    def btn_pick_main_image_command(self):
        print("command22")

    def btn_delete_background_command(self):
        print("command23")

    def btn_save_deleted_background_image_command(self):
        print("command24")

    def openfile(self):
        ftypes = [('JPG files', '*.jpg'),
                  ('PNG files', '*.png'),
                  ('All files', '*')]
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
