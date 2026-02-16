import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Dashboard() {
  const navigate = useNavigate();
  const [loading, setLoading] = useState(true);
  const [activeTab, setActiveTab] = useState('home');
  
  // NEW: State to control if the custom modal is visible
  const [showModal, setShowModal] = useState(false);

  useEffect(() => {
    const token = localStorage.getItem('session_token');
    if (!token) {
      navigate('/login');
    } else {
      setLoading(false);
    }
  }, [navigate]);

  // When the user clicks the top right Logout button, just show the modal
  const handleLogoutClick = () => {
    setShowModal(true);
  };

  // If they click "Cancel" inside the modal, hide it
  const cancelLogout = () => {
    setShowModal(false);
  };

  // If they click "Yes, Log Out" inside the modal, actually log them out
  const confirmLogout = () => {
    localStorage.removeItem('session_token');
    navigate('/login');
  };

  if (loading) return <div className="auth-wrapper"><h2>Loading...</h2></div>;

  return (
    <div className="dashboard-container">
      <nav className="navbar">
        <div className="nav-left">
          <div className="nav-logo">Test App</div>
          <button className={`nav-tab ${activeTab === 'home' ? 'active' : ''}`} onClick={() => setActiveTab('home')}>Home</button>
          <button className={`nav-tab ${activeTab === 'profile' ? 'active' : ''}`} onClick={() => setActiveTab('profile')}>Profile</button>
        </div>
        
        {/* Changed this to just trigger the modal */}
        <button className="btn-logout" onClick={handleLogoutClick}>Logout</button>
      </nav>

      <div className="dashboard-content">
        {activeTab === 'home' && (
          <div className="content-card">
            <h2 style={{ color: '#0056b3', marginBottom: '15px' }}>Welcome Home!</h2>
            <p style={{ lineHeight: '1.6', color: '#555' }}>
              This is your main dashboard area.
            </p>
          </div>
        )}

        {activeTab === 'profile' && (
          <div className="content-card">
            <h2 style={{ color: '#0056b3', marginBottom: '15px' }}>User Profile</h2>
            <div style={{ display: 'grid', gap: '10px', color: '#555' }}>
              <p><strong>Status:</strong> Authenticated ✅</p>
              <p><strong>Session Token:</strong> <i>{localStorage.getItem('session_token').substring(0, 15)}...</i></p>
            </div>
          </div>
        )}
      </div>

      {/* --- CUSTOM LOGOUT MODAL --- */}
      {/* This only renders if showModal is true */}
      {showModal && (
        <div className="modal-overlay">
          <div className="modal-card">
            <h3>Confirm Logout</h3>
            <p>Are you sure you want to logout?</p>
            <div className="modal-buttons">
              <button className="btn-cancel" onClick={cancelLogout}>Cancel</button>
              <button className="btn-confirm-logout" onClick={confirmLogout}>Yes</button>
            </div>
          </div>
        </div>
      )}

    </div>
  );
}

export default Dashboard;