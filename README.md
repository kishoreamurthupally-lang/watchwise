# 🎬 WatchWise - Movie Recommendation Platform

A full-stack web application that helps users discover and manage movies with personalized recommendations.

---

## 🔗 Live Demo

Frontend 👉 https://watchwise-react.vercel.app  
Backend 👉 https://watchwise-20us.onrender.com  

---

## 🚀 Features

- 🔐 JWT Authentication (Login / Register)
- 📧 OTP Email Verification
- 🔵 Google Login Integration
- 🎯 Movie Recommendation System
- 🎬 Filter by Hollywood / Bollywood / Tollywood
- 👨‍💼 Admin Panel (Add / Update / Delete Movies)
- ⚡ REST API with Spring Boot
- 📊 Actuator Monitoring (Health, Metrics)

---

## 🛠 Tech Stack

### Frontend
- React.js
- Axios
- CSS (Responsive UI)

### Backend
- Spring Boot
- Spring Security (JWT)
- JPA / Hibernate
- MySQL (Railway)

### Tools & Deployment
- Vercel (Frontend)
- Render (Backend)
- Railway (Database)
- SendGrid (Email OTP)

---

## 🔐 Authentication Flow

1. User registers → OTP sent via email  
2. OTP verified → account created  
3. JWT token generated on login  
4. Role-based access (ADMIN / USER)

---

## 📊 Actuator Endpoints

- /actuator/health
- /actuator/info
- /actuator/metrics

---

## 📁 Project Structure
