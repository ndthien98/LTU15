from flask import Flask
from flask import request
from flask import render_template

app = Flask(__name__)

# url_for('static')

@app.route('/')
def index():
    return render_template('index.html')
    
@app.route('/process', methods=['POST'])
def process():
    return render_template('process.html')

@app.route('/user/<username>')
def profile(username):
    return '{}\'s profile'.format(username)
