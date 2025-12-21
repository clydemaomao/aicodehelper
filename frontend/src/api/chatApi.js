import axios from 'axios'

const API_BASE_URL = 'http://localhost:8080/api'

export async function chat(message) {
  const response = await axios.post(`${API_BASE_URL}/chat`, {
    message: message
  })
  return response.data.reply
}

export async function checkServiceHealth() {
  try {
    const response = await axios.get(`${API_BASE_URL}/health`, {
      timeout: 5000
    })
    return response.status === 200
  } catch (error) {
    console.error('Service health check failed:', error)
    return false
  }
}
