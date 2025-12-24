<img width="325" height="239" alt="image" src="https://github.com/user-attachments/assets/f6c26910-15bd-4fdb-b5ea-d57bdea3cf62" />

---

## 🛠 Tech Stack

- **Backend:** Java, Spring Boot, JPA/Hibernate, H2 (in-memory DB)
- **Frontend:** React, TypeScript, Recharts
- **Build Tools:** Maven, npm, Vite
- **Version Control:** Git + GitHub

---

## ⚡ Features

### Backend
- Fetch market summaries for all assets or specific symbols
- Calculate rolling volatility from market prices
- Generate volatility signals (`LOW`, `MEDIUM`, `HIGH`)
- Provide strategy decision (`HOLD`, `BUY`, `SELL`)
- Backtesting framework (work in progress)

### Frontend
- Dashboard to visualize:
  - Rolling volatility chart
  - Volatility signals
  - Strategy actions
- React + Recharts interactive charts (currently in progress)

---

## 🚀 APIs

### Market Data
- `GET /api/market/all` → All assets summary
- `GET /api/market/{symbol}` → Single asset summary

### Quant & Strategy
- `GET /api/quant/volatility/{symbol}?window=5` → Rolling volatility
- `GET /api/quant/signal/{symbol}?window=5` → Latest volatility signal
- `GET /api/quant/strategy/{symbol}?window=5` → Latest strategy decision

---

## 📌 Current Status

- **Backend:** 95% complete, fully functional endpoints  
- **Frontend:** 25% complete, chart components in progress  
- **Integration:** Pending  
- **Visualization & Styling:** Pending  

---

## 📝 Notes

- Backend service is stable; some endpoints may throw runtime errors for insufficient data  
- Frontend charts may show white screen until TypeScript types and dummy data are fixed  
- Future work:
  - Connect frontend to backend APIs
  - Implement backtesting visualization
  - Enhance styling and dashboard layout

---

## 💻 Running the Project

### Backend
```bash
cd backend
mvn spring-boot:run
