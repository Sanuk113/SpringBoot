// App.tsx

import React, { useState } from 'react';
import './App.css';

interface Item {
  id: number;
  name: string;
  price: number;
}

const App: React.FC = () => {
  const [items, setItems] = useState<Item[]>([]);
  const [itemName, setItemName] = useState('');
  const [itemPrice, setItemPrice] = useState(0);

  const addItem = (e: React.FormEvent) => {
    e.preventDefault();
    const newItem: Item = {
      id: items.length + 1,
      name: itemName,
      price: itemPrice,
    };
    setItems([...items, newItem]);
    setItemName('');
    setItemPrice(0);
  };

  return (
    <div className="App">
      <header>
        <h1>Item Management</h1>
      </header>

      <div className="container">
        <form onSubmit={addItem}>
          <h2>Add New Item</h2>
          <label htmlFor="name">Item Name:</label>
          <input
            type="text"
            id="name"
            value={itemName}
            onChange={(e) => setItemName(e.target.value)}
            required
          />

          <label htmlFor="price">Item Price:</label>
          <input
            type="number"
            id="price"
            value={itemPrice}
            onChange={(e) => setItemPrice(Number(e.target.value))}
            required
          />

          <button type="submit">Add Item</button>
        </form>

        <h2>Item List</h2>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Price</th>
            </tr>
          </thead>
          <tbody>
            {items.map((item) => (
              <tr key={item.id}>
                <td>{item.id}</td>
                <td>{item.name}</td>
                <td>${item.price.toFixed(2)}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      <footer>
        <p>Item Management App © 2024</p>
      </footer>
    </div>
  );
};

export default App;
